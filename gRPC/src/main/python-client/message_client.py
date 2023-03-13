from __future__ import print_function

import logging

import grpc
import message_pb2
import message_pb2_grpc


def get_message(stub):
    message_response = stub.GetMessage(message_pb2.MessageRequest(message="This is a Python message."))
    print("Server returned a message - %s" % message_response.message)


def run():
    # NOTE(gRPC Python Team): .close() is possible on a channel and should be
    # used in circumstances in which the with statement does not fit the needs
    # of the code.
    with grpc.insecure_channel('localhost:8080') as channel:
        stub = message_pb2_grpc.MessageServiceStub(channel)
        print("-------------- GetFeature --------------")
        get_message(stub)


if __name__ == '__main__':
    logging.basicConfig()
    run()
