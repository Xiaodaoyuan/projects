import requests
import json

API_URL = 'http://localhost:8080/'


def test_get():
    resp = requests.get(API_URL + 'blogs/1')
    print(resp.status_code)
    print(resp.content.decode('utf-8'))
    if resp.status_code == 200 and resp.content:
        print(resp.json())
    else:
        print(resp.status_code)
        print(resp.content)


if __name__ == '__main__':
    test_get()
