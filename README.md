# coffee-shop
Code to demonstrate unit testing, integration testing, BDD testing

## Build the code

`mvn clean install`

## Build the container

`docker build -t benlidgey/coffeeshop .`

## Run container

To run the container:

`docker run -p 8888:8080 benlidgey/coffeeshop`

Then goto [http://localhost:8888]

# Continual Integration environments

Currently trialling Travis-CI and CodeShip for CI builds online.
