FROM openjdk:14-alpine

COPY target/kafka-consumer-*.jar /kafka-consumer.jar

ENV kafka_bootstrapServer 192.168.1.21:9092

CMD ["java", "-jar", "/kafka-consumer.jar"]


