# checkers-rules-api
Api to give possible chain moves

## Getting Started
### Requirements
* Java 9

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
#### To work on checkers-rules-api
Run checkers-rules-api like that:
```
mvn clean package
java -jar ./target/checkers-rules-api-{VERSION}-SNAPSHOT.jar
```
http://localhost:8080 is base url of API

#### Documentation
##### Swagger documentation
The api documentation accessible at http://localhost:8080/swagger-ui.html

## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>
