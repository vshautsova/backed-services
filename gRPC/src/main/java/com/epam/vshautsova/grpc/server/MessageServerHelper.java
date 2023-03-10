package com.epam.vshautsova.grpc.server;

import com.epam.vshautsova.grpc.util.Constants;
import io.grpc.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Helper class to manage server states.
 */
public class MessageServerHelper
{
	private static final Logger LOGGER = LogManager.getLogger(MessageServerHelper.class);

	/**
	 * Starts the gRPC server.
	 *
	 * @throws IOException exception
	 */
	public static void start(Server server) throws IOException
	{
		LOGGER.info("Starting gRPC server...");
		server.start();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> handleShutdown(server)));
	}

	/**
	 * Awaits termination on the main thread since the grpc library uses daemon threads.
	 *
	 * @throws InterruptedException exception
	 */
	public static void blockUntilShutdown(Server server) throws InterruptedException
	{
		if (server != null)
		{
			server.awaitTermination();
		}
	}

	/**
	 * Handles shutdown.
	 *
	 * @param server Server
	 */
	private static void handleShutdown(Server server)
	{
		System.err.println("Shutting down gRPC server since JVM is shutting down");
		try
		{
			stop(server);
		} catch (InterruptedException e)
		{
			e.printStackTrace(System.err);
		}
		System.err.println("gRPC server is shut down");
	}

	/**
	 * Stops the gRPC server.
	 *
	 * @throws InterruptedException exception
	 */
	private static void stop(Server server) throws InterruptedException
	{
		if (server != null)
		{
			server.shutdown().awaitTermination(Constants.SERVER_SHUTDOWN_AWAITING_AMOUNT, TimeUnit.SECONDS);
		}
	}
}
