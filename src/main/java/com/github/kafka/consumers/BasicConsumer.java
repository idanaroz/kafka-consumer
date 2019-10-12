package com.github.kafka.consumers;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Component
public class BasicConsumer implements Consumer {


    @Value("${kafka_bootstrapServer}")
    String bootstrapServer;

    @PostConstruct
    public void run() {
        final Logger logger = LoggerFactory.getLogger(BasicConsumer.class);
        logger.info("\n **********************************************\n " +
                "The bootstrapServer is=" + bootstrapServer +
                "\n ********************************************** ");


        String groupId = "my-first-kafka-services";
        String offsetConfig = "earliest";
        String topic = "second_topic"; //Todo: update the topic with a better first name

        //create consumer properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetConfig);

        //create the consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        // subscribe consumer to our topics
        consumer.subscribe(Arrays.asList(topic));


//        ConsumerRecord<String, String> record = new ConsumerRecord<String, String>("second_topic", "hello world");

        //poll for new data
        while (true) {
            ConsumerRecords<String, String> records =
                    consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord record : records) {
//                logger.info("Key" + record.key() + "\n" +
//                        "Value: " + record.value());
//                logger.info("Partition: " + record.partition() +"\n" +
//                        "Offset: " + record.offset());
                logger.info("\n" + record.value() + "\n");
            }
        }


    }


}
