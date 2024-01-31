FROM openjdk:17-jdk-slim

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/docker-0.0.1-SNAPSHOT.jar"]