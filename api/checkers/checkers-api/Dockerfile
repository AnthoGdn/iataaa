FROM openjdk:9-jdk
MAINTAINER Anthony Godin <gdn.anthony@gmail.com>

ENV VERSION 0.1.0
ADD ./target/checkers-api-$VERSION-SNAPSHOT.jar /app/
ENTRYPOINT java -jar "/app/checkers-api-$VERSION-SNAPSHOT.jar"

EXPOSE 8080
