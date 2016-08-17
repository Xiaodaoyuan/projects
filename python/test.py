# -*- coding: utf-8 -*-
import requests
import json


HOST_ADDR = 'http://localhost:8080'


def main():
    resp = requests.get(HOST_ADDR + '/maven_ssm/cache/key/hot_words_c')
    print(resp.status_code)
    print(resp.json())
    cache = resp.json().get('value')
    print(cache.get('jobs'))
    print(type(cache))


if __name__ == '__main__':
    main()