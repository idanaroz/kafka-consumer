FROM openjdk:14-alpine

COPY target/consumer-*.jar /consumer.jar

ENV kafka_bootstrapServer 0.0.0.0:9092

CMD ["java", "-jar", "/producer.jar"]


