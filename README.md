# coffee-shop
Code to demonstrate unit testing, integration testing, BDD testing

# Run the maven build
`mvn clean install`

# Build the container
The build uses the Spotify dockerfile-maven plugin to build the Docker image as part of the build. Therefore to build the container:
`mvn package`

# Push the build to the Docker repository
`mvn deploy`

# Run container
To run the container:

`docker run -p 8888:8080 brighterthanblue/coffeeshop:{pom.version}`

Then goto [http://localhost:8888]

# Continual Integration environments

CircleCI
