FROM maven:3.8.5-openjdk-11-slim AS build

COPY /src /app/src

COPY /pom.xml /app

RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM openjdk:11

LABEL key="core.kswelder"

WORKDIR /usr/src/app

COPY --from=build /app/target/*.jar kswelder.jar

EXPOSE 8081

ENTRYPOINT ["mvn", "spring-boot:run"]