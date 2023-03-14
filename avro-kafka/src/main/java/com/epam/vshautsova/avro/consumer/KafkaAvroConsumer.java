package com.epam.vshautsova.avro.consumer;

import com.epam.vshautsova.avro.AvroMessage;
import com.epam.vshautsova.avro.util.PropertiesHelper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.List;

/**
 * Kafka consumer with Avro.
 */
public class KafkaAvroConsumer
{
	private static final Logger LOGGER = LogManager.getLogger(KafkaAvroConsumer.class);

	private final String topic;
	private final KafkaConsumer<String, AvroMessage> consumer;

	public KafkaAvroConsumer(String topic, String kafkaServer, String schemaRegistry, String groupId)
	{
		this.topic = topic;
		this.consumer = new KafkaConsumer<>(PropertiesHelper.getConsumerProperties(kafkaServer, schemaRegistry, groupId));
	}

	/**
	 * Consumes a message.
	 */
	public void consume()
	{
		consumer.subscribe(List.of(topic));

		for (int i = 0; i < 10; i++)
		{
			ConsumerRecords<String, AvroMessage> records = consumer.poll(Duration.ofMillis(100));

			for (ConsumerRecord<String, AvroMessage> record : records)
			{
				LOGGER.info("Value: " + record.value());
				LOGGER.info("Partition: " + record.partition() + ", Offset:" + record.offset());
			}
		}
	}
}
