package com.wbaa.experiment.kafkastream;

import com.wbaa.experiment.kafkastream.avro.Demo;
import com.wbaa.experiment.kafkastream.consumer.MessageConsumer;
import com.wbaa.experiment.kafkastream.producer.MessageProducer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Collections;

public class App {

    public static void main(String[] args) {


        KafkaProducer<String, String> producer = MessageProducer.createProducer();
        for (int index = 0; index < 10; index++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("test5",
                    index + " blabla");
            System.out.println("Sending record with index " + index + 1);
            producer.send(record);
            System.out.println("Record sent with index " + index + 1);
        }

        producer.flush();

//        KafkaConsumer<String, String> consumer = MessageConsumer.createConsumer();
//        consumer.subscribe(Collections.singletonList("kafka-stream"));
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
////                String key = record.key();
////                Demo value = record.value();
//                System.out.println("Record consumed" + record);
//            }
//        }
    }

}

