# Oauth Service
Oauth Service

## the pre-requisites
* You have to install Java 8.
* You have to install Maven 3.

## Technologies: 
* Spring REST
* Spring AOP
* Spring Data JPA
* HSQL
* Swagger
* Spring Test
* Spring web  

### Run test methods:
```
Use "mvn clean package" to run the tests with HSQL DB.
```

### Run in development envirenment:
To run the project with **spring-boot:run** in development environment.
In development enviroment you will be able to make more instances according the number of request 
if you can config spring cloud(Eureka) in this project and make a instance from its Eureka server.
```
This sample uses a HSQL database and you do not need to install and config a data base.
After runing you can test and see API(s) on a browser by this URL http://localhost:8080/swagger-ui.html.  
```

### Run in production environment:
Use java -jar file with the below command:  
**java -jar -Dspring.profiles.active=prod jarName.jar**

## Task lists
You can use these following stack technology to make the application more enterprise:
- [ ] Spring Security
- [ ] Spring Cloud
- [ ] Spring Session
- [ ] Spring Oauth2
- [ ] API gateway like Zuul
- [ ] Circuit breaker
- [ ] Spring Cache