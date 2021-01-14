# envers-example

An Example for integrating Spring boot and Hibernate Envers. The Envers module aims to provide an easy auditing/versioning solution for entity classes.

## Features

- Auditing of all mappings defined by the JPA specification
- Auditing some Hibernate mappings that extend JPA, e.g. custom types and collections/maps of "simple" types like Strings, Integers.
- Logging data for each revision using a "revision entity"
- Querying historical snapshots of an entity and its associations

## Revisioning

Much like source code version control, Envers uses a concept of revisions.

A revision identifies a collection of changes to entities and their associations for all audited attributes that occured within the boundary of a transaction. These revisions are global and numeric.

The AuditReader API provides numerous ways to query for entities at particular revisions and retrieve a partial view of what that entity looked like at that specific revision. It also allows you to get access to lists of revisions associated with an entity type or restricted by a date range. The API also provides a way to get the revision metadata so you can know when a change occured plus any additional custom attributes you may have stored on the revision entity based on your implementation needs.

## Getting started

### Prerequisites:

- Java 11
- Spring Boot 2.4.1
- Hibernate Envers
- Maven as our project management and comprehension tool
- MySQL as our Database

### Tools:
- IntelliJ IDEA
- Mapstruct for implementation of mappings between Java bean types
- Open Api and Swagger for describing RESTful APIs expressed
- Flyway as our database-migration tool
- Lombok 
- Prettier as our code formatter
- Spotify docker-maven-plugin for building docker images

### Clone the repository

```bash
    git clone https://github.com/SaeedSatari/envers-example.git
```

### Setup the database prerequisites

- Create a schema with 'envers-example' name
- Create a user with 'enversexampleapp' username and 'enversexampleapp' password

### Run the app using maven

```bash
    cd envers-example
    mvn spring-boot:run
```

### Accessing to all the APIs

```bash
    http://localhost:8080/swagger-ui.html
```

### Build image using docker-maven-plugin

```bash
    mvn clean package docker:build
```

### Push image using docker-maven-plugin

To push the image you just built to the registry, specify the pushImage flag.

```bash
    mvn clean package docker:build -DpushImage
```

### Formatting using prettier-maven-plugin

```bash
    mvn prettier:write
```

I hope this example helps developers who want to learn more about Hibernate Envers and Spring Boot integrity.
If you have any questions, please feel free to reach me by emai: saeedsatari93@gmail.com 