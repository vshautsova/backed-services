package com.epam.vshautsova.grpc.server;

import com.epam.vshautsova.grpc.service.MessageService;
import com.epam.vshautsova.grpc.util.Constants;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * gRPC server.
 */
public class MessageServer
{
	private final int port;
	private final Server server;

	public MessageServer(int port)
	{
		this(port, Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create()));
	}

	public MessageServer(int port, ServerBuilder<?> serverBuilder)
	{
		this.port = port;
		this.server = serverBuilder.addService(new MessageService()).build();
	}

	/**
	 * Starts the server.
	 *
	 * @param args args
	 * @throws InterruptedException exception
	 * @throws IOException exception
	 */
	public static void main(String[] args) throws InterruptedException, IOException
	{
		MessageServer messageServer = new MessageServer(Constants.SERVER_DEFAULT_PORT);
		MessageServerHelper.start(messageServer.server);
		MessageServerHelper.blockUntilShutdown(messageServer.server);
	}
}
