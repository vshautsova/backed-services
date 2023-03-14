package com.epam.vshautsova.avro.producer;

import com.epam.vshautsova.avro.AvroMessage;
import com.epam.vshautsova.avro.util.PropertiesHelper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Kafka producer with Avro.
 */
public class KafkaAvroProducer
{
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
				System.out.println("Success");
				System.out.println(recordMetadata.toString());
			}
			else
			{
				System.err.println("Failure");
				System.err.println(exception.getMessage());
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
