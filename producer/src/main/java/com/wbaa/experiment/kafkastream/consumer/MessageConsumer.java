package com.wbaa.experiment.kafkastream.consumer;

import com.wbaa.experiment.kafkastream.avro.Demo;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class MessageConsumer {
    public static KafkaConsumer<String, String> createConsumer() {

        Properties props = new Properties();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://0.0.0.0:8085");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"http://localhost:29092");
        return new KafkaConsumer<String, String>(props);
    }

}
