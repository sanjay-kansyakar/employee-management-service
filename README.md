# Employee Management Service Spring Boot Application

Employee Management Service spring boot application to create and get employees.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Building the application locally

```shell
mvn clean install
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.socgen.ems.employee.EmployeeManagementServiceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Swagger Documentation

[EMS-1.0.0.yaml](https://github.com/sanjay-kansyakar/employee-management-service/blob/main/EMS-1.0.0.yaml) - Shows the list of Endpoints in the current RESTful webservice.

Open [Swagger Editor](https://editor.swagger.io/) and paste content of EMS-1.0.0.yaml or import EMS-1.0.0.yaml file if you have downloaded file locally.
