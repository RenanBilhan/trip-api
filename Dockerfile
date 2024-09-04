FROM eclipse-temurin:17.0.8.1_1-jdk-jammy AS builder
WORKDIR /trip-api
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

COPY src ./src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17.0.8.1_1-jdk-jammy
WORKDIR /trip-api
COPY --from=builder /trip-api/target/trip-api-0.0.1-SNAPSHOT.jar /trip-api/trip-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "trip-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080