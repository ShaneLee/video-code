#!/usr/bin/python
from pandas_datareader import data
from pandas_datareader._utils import RemoteDataError
import pandas as pd
import numpy as np
from operator import itemgetter
import datetime
import csv

below_mean = []

def get_stocks():
    tickers = []
    with open('tickers.csv') as ticker_file:
        for ticker in ticker_file:
            tickers.append(ticker.strip())
    return tickers

def to_csv(stocks):
    with open('below_mean.csv', 'w') as output:
        writer = csv.writer(output)
        writer.writerow(stocks[0].keys())
        for stock in stocks:
            writer.writerow(stock.values())

def reindex_column(panel_data, key, all_weekdays):
    column = panel_data[key].reindex(all_weekdays)
    return column.fillna(method='ffill')

def replace_dot(ticker):
    return ticker.replace('.', '-') + '.L'

def check_dot(ticker):
    if '.' in ticker[-1]:
        return ticker + 'L'
    elif '.'in ticker[-2]:
        return replace_dot(ticker)
    else: 
        return ticker + '.L'

def get_last_day_data(ticker):
    ticker_l = check_dot(ticker)
    now = datetime.datetime.now()
    start_date = '2005-01-01'
    end_date = str(now.strftime('%Y-%m-%d'))
    all_weekdays = pd.date_range(start=start_date, end=end_date, freq='B')

    try: 
        panel_data = data.DataReader(ticker_l, 'yahoo', start_date, end_date)
        adj_close = reindex_column(panel_data, 'Adj Close', all_weekdays)
        moving_mean_200_days = np.mean(adj_close.tail(200))
        print(ticker_l + ' moving 200 day mean: ' + str(moving_mean_200_days))

        current_price = np.mean(adj_close.tail(1))
        long_mean_diff = current_price - moving_mean_200_days
        long_mean_percent_diff = (long_mean_diff / current_price) * 100


        stock = {
            'ticker': ticker, 
            'date': end_date,
            'current_price': current_price,
            'moving_mean_200_days': moving_mean_200_days,
            'long_mean_percent_diff': long_mean_percent_diff
            }

        if current_price > moving_mean_200_days:
            print('Price of ' + ticker + ' is greater than 200 days moving mean')
        else: 
            print('Price of ' + ticker + ' is less than 200 days moving mean')
            below_mean.append(stock)
    except:
        print('Error for '+ ticker_l)

if __name__ == '__main__':
    for ticker in get_stocks()[:5]:
        get_last_day_data(ticker)
    to_csv(below_mean)
