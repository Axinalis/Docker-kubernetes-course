FROM maven:3.8.5-eclipse-temurin-17 AS MAVEN_BUILD

COPY ./ ./

RUN mvn clean package

FROM openjdk:17-jdk-alpine3.12

COPY --from=MAVEN_BUILD /target/ /

CMD ["java", "-jar", "/learningKuber-0.0.1.jar"]