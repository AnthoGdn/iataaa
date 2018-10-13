# IAtaaa UI
It's user interface project of IAtaaa. For now, it's possible to create checkers and play against computer.

## Getting Started
### Requirements
* Docker
* Docker Compose
* npm

### Develop mode
You can use Docker Compose to run all api :
```sh
docker-compose up -d
```

Server | URL | API Documentation
------ | ------ | ------
checkers-api | 172.16.0.10:8080 | http://172.16.0.10:8080/swagger-ui.html
checkers-rules-api | 172.16.0.20:8080 | http://172.16.0.20:8080/swagger-ui.html
checkers-api database | 172.16.0.15:3036 |

To run and develop user interface, please run:
```sh
npm start
```
Navigate to [http://localhost:3000](http://localhost:3000)

## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>
