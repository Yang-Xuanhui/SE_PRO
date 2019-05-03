# Best Pratice of Microservice

## splite homework2 REST Service into two microservices

part a: login

part b: wordladder

通过login服务向wordladder服务发送http请求，而不直接向wordladder发送请求

login的端口为8082，wordladder的端口为8081

通过 (http://168.192.99.100:8082/search) 可以间接的访问到wordladder的get_wordladder接口

## pull images from docker hub

```
docker pull yangxh99/word-ladder
docker pull yangxh99/login
```

## run images

run word-ladder

```
docker run -d --name=ladder yangxh99/word-ladder
```

run login with a link of word-ladder

```
docker run -d -p 8082:8099 --link=ladder:ladder --name=withLogin yangxh99/login
```