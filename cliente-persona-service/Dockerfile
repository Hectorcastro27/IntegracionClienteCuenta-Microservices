FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/cliente-persona-service.jar cliente-persona-service.jar
ENTRYPOINT ["java", "-jar","/cliente-persona-service.jar"]