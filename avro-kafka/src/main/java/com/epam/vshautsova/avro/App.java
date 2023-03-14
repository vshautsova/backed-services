package com.epam.vshautsova.avro;

import com.epam.vshautsova.avro.consumer.KafkaAvroConsumer;
import com.epam.vshautsova.avro.producer.KafkaAvroProducer;
import com.epam.vshautsova.avro.util.Constants;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Main app to run kafka consumer & producer.
 *
 */
public class App 
{
    /**
     * Runner.
     *
     * @param args args
     */
    public static void main(String[] args)
    {
        KafkaAvroProducer producer =
                new KafkaAvroProducer(Constants.TOPIC, Constants.KAFKA_SERVER, Constants.SCHEMA_REGISTRY);
        KafkaAvroConsumer consumer =
                new KafkaAvroConsumer(Constants.TOPIC, Constants.KAFKA_SERVER, Constants.SCHEMA_REGISTRY, "message-group");

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        try
        {
            executor.scheduleAtFixedRate(
                    producer::produce, Constants.EXECUTOR_DELAY, Constants.EXECUTOR_PERIOD, TimeUnit.SECONDS);
            consumer.consume();
        }
        finally
        {
            producer.shutDown();
        }
    }
}
