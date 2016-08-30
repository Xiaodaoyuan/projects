# -*- coding: utf-8 -*-

import json
import requests

ONEBOX_HOST = 'http://localhost:8080/maven_ssm/'
CACHE_DATA_URL = ONEBOX_HOST + 'cache/'

HEADERS = {
    'Content-Type': 'application/json'
}


def load_cache_data():
    return [
        {
            'cacheKey': 'hot_words_b',
            'value': {'jobs': ['java', 'android', '产品经理'], 'companies': ['百度', '阿里', 'Google']}
        },
        {
            'cacheKey': 'hot_words_c',
            'value': {'jobs': ['java', 'android', '产品经理'], 'companies': ['百度', '阿里', 'Google']}
        },
        {
            'cacheKey': 'name',
            'value': {'name': 'xiaodyxiaoxiao', 'age': 24}
        }
    ]


def main():
    entries = load_cache_data()

    for entry in entries:
        resp = requests.post(CACHE_DATA_URL, data=json.dumps(entry), headers=HEADERS)
        print(resp.status_code)
        print(resp.json())


if __name__ == "__main__":
    main()
