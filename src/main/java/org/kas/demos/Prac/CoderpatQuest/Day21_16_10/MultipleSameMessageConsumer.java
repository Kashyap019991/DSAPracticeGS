package org.kas.demos.Prac.CoderpatQuest.Day21_16_10;

//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
/*

java code Kafka we have one topic
I want to add 10 consumers for that topic. Each consumer should consumer
the same messages.
 */




public class MultipleSameMessageConsumer {
/*
    private final String topicName;
    private final String bootstrapServers;
    private final String groupId; // This will be unique for each consumer

    public MultipleSameMessageConsumer(String topicName, String bootstrapServers, String groupId) {
        this.topicName = topicName;
        this.bootstrapServers = bootstrapServers;
        this.groupId = groupId;
    }

    public void startConsuming() {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", bootstrapServers);
        props.setProperty("group.id", groupId);
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // You may need to adjust other properties based on your use case
        // For example, 'auto.offset.reset' to 'earliest' to start from the beginning of the topic

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(Collections.singletonList(topicName));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Topic: %s, Partition: %d, Key: %s, Value: %s, Group: %s%n",
                            record.topic(), record.partition(), record.key(), record.value(), groupId);
                    // Your logic to process the message goes here
                }
                // Commit offsets if you are not using auto-commit
                // consumer.commitSync();
            }
        }
    }

    public static void main(String[] args) {
        String topic = "my-kafka-topic";
        String servers = "localhost:9092"; // Replace with your Kafka broker address

        // Create 10 consumers, each with a different group ID
        for (int i = 1; i <= 10; i++) {
            String consumerGroupId = "group-" + i;
            MultipleSameMessageConsumer myConsumer = new MultipleSameMessageConsumer(topic, servers, consumerGroupId);
            // Run each consumer in a new thread
            new Thread(() -> myConsumer.startConsuming()).start();
        }
    }*/

}