#!/usr/bin/env python
from pandas_datareader import data
from pandas_datareader._utils import RemoteDataError
import pandas as pd
import numpy as np
from operator import itemgetter
import datetime
import csv

weekly_returns = []

def get_stocks():
    tickers = []
    with open('tickers.csv') as ticker_file:
        for ticker in ticker_file:
            tickers.append(ticker.strip())
    return tickers

def to_csv(stocks):
    with open('weekly_returns.csv', 'w') as output:
        writer = csv.writer(output)
        writer.writerow(stocks[0].keys())
        for stock in stocks:
            writer.writerow(stock.values())

def reindex_column(panel_data, key, all_weekdays):
    column = panel_data[key].reindex(all_weekdays)
    return column.fillna(method='ffill')

def calc_return(current, previous):
    return (current - previous) / current * 100

def get_last_week_return(ticker):
    start_date = '2005-01-01'
    end_date = '2020-07-03'

    all_weekdays = pd.date_range(start=start_date, end=end_date, freq='B')

    try: 
        panel_data = data.DataReader(ticker, 'yahoo', start_date, end_date)
        adj_close = reindex_column(panel_data, 'Adj Close', all_weekdays)

        current_price = adj_close[-1]
        last_week_close = adj_close[-6]

        weekly_return = calc_return(current_price, last_week_close)

        weekly_returns.append({
            'ticker': ticker, 
            'week_ending': end_date,
            'current_price': current_price,
            'last_week_close': last_week_close,
            'weekly_return': weekly_return
        })

    except: 
        print('Error for ' + ticker)

if __name__ == '__main__': 
    for ticker in get_stocks()[:5]:
        get_last_week_return(ticker)
    to_csv(weekly_returns)
