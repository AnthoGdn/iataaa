# checkers-api
Api to read and write checkers

## Getting Started
### Requirements
* Java 9
* Docker-Compose

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
#### To work on checkers-api
To run database in docker container :
```sh
cd checkers/checkers-api
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

For example, you can run checkers-api like that:
```
mvn clean package
java -jar -DDB_IP=172.16.0.15 -DDB_PORT=3306 -DDB_DATABASE=iataaa -DDB_USER=iataaa -DDB_PASSWORD=password ./target/checkers-api-{VERSION}-SNAPSHOT.jar
```
http://localhost:8080 is base url of API

#### Documentation
##### Swagger documentation
The api documentation accessible at http://localhost:8080/swagger-ui.html

## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>
