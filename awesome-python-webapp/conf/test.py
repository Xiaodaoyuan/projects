print(isinstance(eval('123'),int))


print(int('02'))

import requests

#resp = requests.post('https://api.douban.com/v2/book/2129650')
#print(resp.json())
#print(resp.status_code)

from urllib import request

res = request.urlopen('https://api.douban.com/v2/book/2129650')
data = res.read()
print(data.decode('utf-8'))