FROM openjdk:14-alpine

CMD "apk update"
CMD "apk upgrade"
CMD "apk add bash"
CMD "apk add curl"

COPY target/kafka-consumer-*.jar /kafka-consumer.jar

ENV kafka_bootstrapServer 192.168.1.21:9092

CMD ["java", "-jar", "/kafka-consumer.jar"]


