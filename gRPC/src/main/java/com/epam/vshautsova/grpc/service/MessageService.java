package com.epam.vshautsova.grpc.service;

import com.epam.vshautsova.grpc.MessageRequest;
import com.epam.vshautsova.grpc.MessageResponse;
import com.epam.vshautsova.grpc.MessageServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * Implementation of gRPC Message Service.
 */
public class MessageService extends MessageServiceGrpc.MessageServiceImplBase
{
	@Override
	public void getMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver)
	{
		responseObserver.onNext(getMessageResponse(request));
		responseObserver.onCompleted();
	}

	/**
	 * Gets Message Response from the given request.
	 *
	 * @param request MessageRequest
	 * @return MessageResponse
	 */
	private MessageResponse getMessageResponse(MessageRequest request)
	{
		return MessageResponse.newBuilder()
				.setMessage(request.getMessage()) // todo: if msg is null, set custom???
				.build();
	}
}
