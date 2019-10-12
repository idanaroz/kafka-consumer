# kafka-consumer
Kafka consumer for docker container

This project main goal is a kafka consumer worker 

Important files:
1. application.properties: include kafka_bootstrapServer var, that can be changed when starting the service
2. Dockerfile which include kafka_bootstrapServer env variable which can be overidden in docker-compose.yml

The image of it (according Dockerfile and jar) could be was uploaded to docker hub: idanaroz/kafka-server-consumer
