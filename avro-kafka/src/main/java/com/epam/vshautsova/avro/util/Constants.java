package com.epam.vshautsova.avro.util;

/**
 * Constants class.
 */
public final class Constants
{
	public static final String TOPIC = "message-avro";
	public static final String KAFKA_SERVER = "127.0.0.1:9092";
	public static final String SCHEMA_REGISTRY = "http://127.0.0.1:8081";
	public static final String SCHEMA_REGISTRY_CONFIG = "schema.registry.url";
	public static final String AUTO_OFFSET_RESET_EARLIEST = "earliest";
	public static final int EXECUTOR_DELAY = 0;
	public static final int EXECUTOR_PERIOD = 1;
}
