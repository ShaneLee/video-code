import json
import requests
from bs4 import BeautifulSoup as bs

URL = input('Enter the url: ')

page = requests.get(URL)

soup = bs(page.text, 'html.parser')

page_data = [ json.loads(x.string) for x in soup.find_all('script',
type='application/ld+json') ]

for x in page_data:
    try:
        print(x['articleBody'])
    except KeyError:
        pass


