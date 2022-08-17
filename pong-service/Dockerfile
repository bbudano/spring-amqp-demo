FROM openjdk:11-jre
COPY ./target/pong-service-*.jar service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service.jar"]