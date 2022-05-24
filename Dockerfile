FROM openjdk:17-jdk-alpine3.12

COPY /target/ /

CMD ["java", "-jar", "/learningKuber-0.0.1.jar"]