# IAtaaa API
Contains 2 api to implement checkers.

## Getting Started
### Requirements
* Java 9
* Docker
* Docker Compose

**Indication**: It's recommended to use `./mvnw` command instead of `mvn`.

### Maven Modules
These modules are located in `checkers` directory. 
* checkers-domain : implementation of checkers rules
* checkers-dto : contains Data Transfer Objects (DTO)
* checkers-domain-dto-mapper : library to map domain to dto and conversely
* checkers-test-util : library contains test utils
* checkers-api : api to read and write checkers (**contains README**)
* checkers-rules-api : api to give possible chain moves (**contains README**)

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

### Run all api
You can use Docker Compose to run all api :
```sh
docker-compose up -d
```

Server | URL | API Documentation
------ | ------ | ------
checkers-api | 172.16.0.10:8080 | http://172.16.0.10:8080/swagger-ui.html
checkers-rules-api | 172.16.0.20:8080 | http://172.16.0.20:8080/swagger-ui.html
checkers-api database | 172.16.0.15:3036 |

### Insomnia
Insomnia is REST client. It is document all routes of api. 
You can load `insomnia_iataaa.json` to test manually our api or to see request payload.

**Warning**: You may need to redefine `ApiUrl` in environment variables of insomnia. This variable is url of api that you test.
* If you use Docker Compose, `ApiUrl` must be equal to `http://172.16.0.*:8080` (replace `*` by good number)
* If you don't use Docker Compose, you execute `.jar`, `ApiUrl` must be equal to `http://127.0.0.1:8080`


## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>
