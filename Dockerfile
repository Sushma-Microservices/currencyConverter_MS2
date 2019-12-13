FROM openjdk:8
ADD target/currency-converter-microservice-0.0.1-SNAPSHOT.jar currency-converter-microservice-0.0.1-SNAPSHOT.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "currency-converter-microservice-0.0.1-SNAPSHOT.jar"]