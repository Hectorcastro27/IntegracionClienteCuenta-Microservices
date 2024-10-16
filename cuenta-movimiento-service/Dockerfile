FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/cuenta-movimiento-service.jar cuenta-movimiento-service.jar
ENTRYPOINT ["java", "-jar","/cuenta-movimiento-service.jar"]