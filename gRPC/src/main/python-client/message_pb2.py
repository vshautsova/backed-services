# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: message.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import builder as _builder
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\rmessage.proto\x12\x18\x63om.epam.vshautsova.grpc\"!\n\x0eMessageRequest\x12\x0f\n\x07message\x18\x01 \x01(\t\"\"\n\x0fMessageResponse\x12\x0f\n\x07message\x18\x01 \x01(\t2u\n\x0eMessageService\x12\x63\n\nGetMessage\x12(.com.epam.vshautsova.grpc.MessageRequest\x1a).com.epam.vshautsova.grpc.MessageResponse\"\x00\x42\x1c\n\x18\x63om.epam.vshautsova.grpcP\x01\x62\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'message_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\030com.epam.vshautsova.grpcP\001'
  _MESSAGEREQUEST._serialized_start=43
  _MESSAGEREQUEST._serialized_end=76
  _MESSAGERESPONSE._serialized_start=78
  _MESSAGERESPONSE._serialized_end=112
  _MESSAGESERVICE._serialized_start=114
  _MESSAGESERVICE._serialized_end=231
# @@protoc_insertion_point(module_scope)
