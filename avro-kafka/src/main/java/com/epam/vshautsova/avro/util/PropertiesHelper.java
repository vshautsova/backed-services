package com.epam.vshautsova.avro.util;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Helper class to get properties for kafka producer/consumer.
 */
public class PropertiesHelper
{
	/**
	 * Gets kafka producer properties.
	 *
	 * @param kafkaServer kafka server
	 * @param schemaRegistry schema registry
	 * @return built properties
	 */
	public static Properties getProducerProperties(String kafkaServer, String schemaRegistry)
	{
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		properties.setProperty(Constants.SCHEMA_REGISTRY_CONFIG, schemaRegistry);
		return properties;
	}

	/**
	 * Gets kafka consumer properties.
	 *
	 * @param kafkaServer kafka server
	 * @param schemaRegistry schema registry
	 * @param groupId group id
	 * @return built properties
	 */
	public static Properties getConsumerProperties(String kafkaServer, String schemaRegistry, String groupId)
	{
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Constants.AUTO_OFFSET_RESET_EARLIEST);
		properties.setProperty(Constants.SCHEMA_REGISTRY_CONFIG, schemaRegistry);
		return properties;
	}
}
