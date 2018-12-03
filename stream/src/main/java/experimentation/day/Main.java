package experimentation.day;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;
import java.util.regex.Pattern;


public class Main {
    private static final  String TOPIC = "stream-topic";


    private final static String bootstrapServers = "localhost:29092";

    public static void main(String[] args) {

        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "demo-app");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass().getName());
        streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        final StreamsBuilder builder = new StreamsBuilder();
        final KStream<String, String> input = builder.stream(TOPIC);

        KTable<String, Long> table = input.filter((k, v) -> v.length() > 5).groupBy((key, val) -> val).count();
        table.toStream().to("streams-output");




        




    }
}
