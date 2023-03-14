# NoSQL Microservices


## Introduction


```shell
mvn clean package
```
This will create an executable jar file **jnosql-microservices.jar** within the _target_ maven folder. This can be started by executing the following command

```shell
java -jar target/jnosql-microservices.jar
```


### Liberty Dev Mode

During development, you can use Liberty's development mode (dev mode) to code while observing and testing your changes on the fly.
With the dev mode, you can code along and watch the change reflected in the running server right away; 
unit and integration tests are run on pressing Enter in the command terminal; you can attach a debugger to the running server at any time to step through your code.

```shell
mvn liberty:dev
```

To launch the test page, open your browser at the following URL

```shell
http://localhost:9080/index.html  
```

## Using Docker

1. Install docker: https://www.docker.com/
2. https://store.docker.com/images/mongo
3. Run docker command
4. Run MongoDB: verify MongoDB image name with the command `docker images`, it can be mongodb or mongo, and then execute this command
    1. `docker run -d --name mongodb-instance -p 27017:27017 mongo`


## Insert data


```shell
curl --location --request PUT 'http://localhost:9080/library' \
--header 'Content-Type: application/json' \
--data-raw '{"isbn": "1231", "title": "Effective Java", "year": 2012}'


curl --location --request PUT 'http://localhost:9080/library' \
--header 'Content-Type: application/json' \
--data-raw '{"isbn": "1", "title": "Modern Software Engineering: Doing What Works to Build Better Software Faster", "year": 2021}'


curl --location --request PUT 'http://localhost:9080/library' \
--header 'Content-Type: application/json' \
--data-raw '{"isbn": "2", "title": "Clean Code", "year": 2008}'


curl --location --request GET 'http://localhost:9080/library'

curl --location --request DELETE 'http://localhost:9080/library/1'
```
