FROM openjdk:17-jdk-alpine
WORKDIR /api
COPY target/helpdesk-0.0.1-SNAPSHOT.jar api.jar
EXPOSE 8080
CMD ["java", "-jar", "api.jar"]