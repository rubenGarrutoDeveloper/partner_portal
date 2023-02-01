# pulling our base image
FROM maven:3.8.6-jdk-8

# deployment dir
WORKDIR /partner-portal

# copy all current dir to /partner-portal
COPY . /partner-portal

# maven command, clean deps and install deps
RUN mvn clean install

# set the startup command to run your binary
CMD ["java", "-jar", "./partner-portal-demo-01-1.0.0.jar"]