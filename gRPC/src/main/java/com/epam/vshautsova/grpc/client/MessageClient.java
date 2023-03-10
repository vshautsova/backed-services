package com.epam.vshautsova.grpc.client;

import com.epam.vshautsova.grpc.MessageRequest;
import com.epam.vshautsova.grpc.MessageResponse;
import com.epam.vshautsova.grpc.MessageServiceGrpc;
import com.epam.vshautsova.grpc.util.Constants;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * gRPC client.
 */
public class MessageClient
{
	private static final Logger LOGGER = LogManager.getLogger(MessageClient.class);

	private final MessageServiceGrpc.MessageServiceBlockingStub blockingStub;

	public MessageClient(Channel channel)
	{
		this.blockingStub = MessageServiceGrpc.newBlockingStub(channel);
	}

	/**
	 * Gets message from the gRPC server.
	 */
	public void getMessage()
	{
		LOGGER.info("Getting Message");
		MessageRequest messageRequest = MessageRequest.newBuilder()
				.setMessage("Hello")
				.build();

		MessageResponse messageResponse = blockingStub.getMessage(messageRequest);
		LOGGER.info("Message response = " + messageResponse.getMessage());
	}

	/**
	 * Starts the client.
	 *
	 * @param args args
	 * @throws InterruptedException exception
	 */
	public static void main(String[] args) throws InterruptedException
	{
		LOGGER.info("Starting gRPC client...");
		ManagedChannel channel = Grpc.newChannelBuilder(Constants.SERVER_HOST, InsecureChannelCredentials.create())
				.build();
		try
		{
			MessageClient client = new MessageClient(channel);
			client.getMessage();
		}
		finally
		{
			channel.shutdownNow().awaitTermination(Constants.CHANNEL_SHUTDOWN_AWAITING_AMOUNT, TimeUnit.SECONDS);
		}
	}
}
