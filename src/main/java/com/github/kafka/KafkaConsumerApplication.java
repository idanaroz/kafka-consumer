package com.github.kafka;

import com.github.kafka.consumers.BasicConsumer;
import com.github.kafka.consumers.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(KafkaConsumerApplication.class, args);

//		Consumer consumer = new ConsumerWithThread();
        Consumer consumer = new BasicConsumer();
        consumer.run();
    }

}
