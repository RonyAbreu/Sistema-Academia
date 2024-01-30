FROM openjdk:17-jdk-slim

COPY . .

RUN ./mvnw install

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/docker-0.0.1-SNAPSHOT.jar"]