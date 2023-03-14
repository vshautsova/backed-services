package com.epam.vshautsova.avro.producer;

import com.epam.vshautsova.avro.AvroMessage;
import com.epam.vshautsova.avro.util.PropertiesHelper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Kafka producer with Avro.
 */
public class KafkaAvroProducer
{
	private static final Logger LOGGER = LogManager.getLogger(KafkaAvroProducer.class);

	private final String topic;
	private final KafkaProducer<String, AvroMessage> kafkaProducer;

	public KafkaAvroProducer(String topic, String kafkaServer, String schemaRegistry)
	{
		this.topic = topic;
		this.kafkaProducer = new KafkaProducer<>(PropertiesHelper.getProducerProperties(kafkaServer, schemaRegistry));
	}

	/**
	 * Produces a message.
	 */
	public void produce()
	{
		AvroMessage message = AvroMessage.newBuilder()
				.setText("Hello world!")
				.build();

		ProducerRecord<String, AvroMessage> producerRecord = new ProducerRecord<>(topic, message);

		kafkaProducer.send(producerRecord, (recordMetadata, exception) -> {
			if (exception == null)
			{
				LOGGER.info("Success: " + recordMetadata.toString());
			}
			else
			{
				LOGGER.info("Failure: " + exception.getMessage());
			}
		});
	}

	/**
	 * Shut downs kafka producer.
	 */
	public void shutDown()
	{
		kafkaProducer.flush();
		kafkaProducer.close();
	}
}
