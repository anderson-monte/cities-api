FROM maven:3.8.5-eclipse-temurin-17-alpine as build

WORKDIR /app

ADD ./pom.xml .
ADD ./src src

RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

FROM azul/zulu-openjdk-alpine:17.0.2-jre

COPY --from=build /app/target/*.jar app.jar

CMD java ${ADDITIONAL_OPS} -jar app.jar