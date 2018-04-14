# IAtaaa

IAtaaa Server is web platform to manage artificial intelligence game. The name IAtaaa stands for the IA (Intelligence Artificielle in french) acronym and the Yatta japanese word for "We did it".

## Getting Started
### Requirements
* Java 9
* Docker-Compose

**Indication**: Use `./mvnw` command instead of `mvn` if you haven't Maven.

### Maven Module
* checkers-domain : implementation of checkers rules
* checkers-dto : contains Data Transfer Objects (DTO)
* checkers-api : api to read and write checkers

#### Build modules
To build maven modules, run :
```sh
mvn clean package
```

#### Run tests modules
To test maven modules, run :
```sh
mvn clean test
```

### Develop mode
#### To work on checkers api
To run database in docker container :
```sh
cd checkers-api
docker-compose up -d
```
To run checkers API, you should add environment variable :

Environment variable | Value
------ | ------ 
DB_IP | 172.16.0.15 |
DB_PORT | 3306 |
DB_DATABASE | iataaa |
DB_USER | iataaa |
DB_PASSWORD | password |

For example, you can run checkers API like that:
```sh
mvn spring-boot:run -DDB_IP=172.16.0.15 -DDB_PORT=3306 -DDB_DATABASE=iataaa -DDB_USER=iataaa -DDB_PASSWORD=password
```
http://localhost:8080 is base url of API

#### Swagger documentation
The api documentation accessible at http://localhost:8080/swagger-ui.html


## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>
