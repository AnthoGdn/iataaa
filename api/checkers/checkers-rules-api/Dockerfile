FROM openjdk:9-jdk
VOLUME /tmp
COPY target/checkers-rules-api-0.1.0-SNAPSHOT.jar checkers-rules-api-0.1.0-SNAPSHOT.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/checkers-rules-api-0.1.0-SNAPSHOT.jar"]
