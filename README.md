# springboot-bank application

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.11](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the Dockerfile like so:
docker build --tag=bank-server:latest
docker run -p8081:8080 bank-server:latest

```shell
mvn spring-boot:run
```

This will create:

* Docker image for the application
* An Image called called "bank-server:latest "
* the application is running on port 8081

#Examples of using the API
-------------------------


* First you should create users by calling POST localhost:8081/user
````
```
{
"firstName":"Ibrahim",
"lastName":"Zahra"
}
```
````

* Create account for that user by calling POST localhost:8081/account, this is a sample body
````
```
{
"userId":1,
"accountType":"Saving"
"currency":"EU"
}
```
````
* you can check the balance by calling GET localhost:8080/account/balance
