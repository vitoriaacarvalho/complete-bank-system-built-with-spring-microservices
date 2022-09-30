FROM maven:3.8.6-jdk-11-slim AS build
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip


#Start with a base image containing Java runtime
FROM openjdk:11-slim

EXPOSE 8080
#Information around who maintains the image
MAINTAINER eazybytes.com

# Add the application's jar to the container
COPY --from=build /app/target/*.jar app.jar

#execute the application
ENTRYPOINT ["java","-jar","/app.jar"]