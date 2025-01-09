FROM amazoncorretto:21-alpine-jdk

COPY target/cursos-online-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7500
ENTRYPOINT ["java", "-jar", "/app.jar"]