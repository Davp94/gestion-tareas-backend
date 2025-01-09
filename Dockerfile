FROM amazoncorretto:21-alpine-jdk

COPY target/gestion-tareas-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7500
ENTRYPOINT ["java", "-jar", "/app.jar"]