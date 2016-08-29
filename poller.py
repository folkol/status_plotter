import requests

url='http://10140.polopoly.ninja:8080/status?rawdata='

beans = {}
for line in requests.get(url).text.splitlines():
     n=line.rfind(':')
     bean = line[:n]
     value = line[n+1:]
     beans[bean] = beans.get(bean) or []
     beans[bean].append(value)

print beans
