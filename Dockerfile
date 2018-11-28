
FROM openjdk:8-jre
MAINTAINER Ben Lidgey <ben@brighterthanblue.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/coffeeshop/coffeeshop.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib           /usr/share/coffeeshop/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/coffeeshop/coffeeshop.jar
