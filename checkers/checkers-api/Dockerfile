FROM openjdk-9-jre
MAINTAINER Anthony Godin <gdn.anthony@gmail.com>

ADD ./target/checkers-api-0.1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/checkers-api-0.1.0-SNAPSHOT.jar"]

EXPOSE 8080
