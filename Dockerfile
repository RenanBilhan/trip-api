FROM eclipse-temurin:17.0.8.1_1-jdk-jammy
WORKDIR /trip-api
COPY . .
RUN ./mvnw clean install -DskipTests
ENTRYPOINT ["java", "-jar", "target/trip-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080