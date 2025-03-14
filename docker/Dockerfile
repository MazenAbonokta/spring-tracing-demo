FROM openjdk:17
WORKDIR /app
COPY ../target/spring-tracing-demo-0.0.1-SNAPSHOT.jar app.jar

RUN mkdir -p /app/libs

# Download OpenTelemetry agent
RUN curl -L -o /app/libs/opentelemetry-javaagent-1.32.0.jar \
    https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.32.0/opentelemetry-javaagent.jar
RUN ls -l /app/libs/

EXPOSE 8089
ENTRYPOINT ["java", "-jar", "app.jar"]
