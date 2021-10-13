# Spring-boot Test-container & Flyway migration
Project to display understand test containers and flyway migration

This project consists of spring boot application which leverages the power of Spring jdbc and Flyway migration to version control our database. 
This application also leverages the power of test containers to create database on the fly, these container database can be used for testing our application.
Spring boot actuator provides various endpoints which enable user to create production ready application. 

## Scripts

### Generate JAR file 
```$ mvn clean install```

### Run Application 
```$ mvn spring-boot:run```

### Generate Docker image 
```$ mvn spring-boot:build-image -Dspring-boot.build-image.imageName=ashwani1218/spring-boot-test-container```
