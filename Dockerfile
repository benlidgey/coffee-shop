
FROM openjdk:latest

COPY target/coffeeshop-0.0.1-SNAPSHOT.jar /usr/src/coffeeshop-0.0.1-SNAPSHOT.jar

CMD java -jar /usr/src/coffeeshop-0.0.1-SNAPSHOT.jar

