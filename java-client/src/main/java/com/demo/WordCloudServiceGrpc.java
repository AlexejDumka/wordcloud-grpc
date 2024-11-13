package com.demo;

import com.demo.Wordcloud;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.1)",
    comments = "Source: wordcloud.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WordCloudServiceGrpc {

  private WordCloudServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "WordCloudService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Wordcloud.WordCloudRequest,
      Wordcloud.WordCloudResponse> getGenerateWordCloudMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateWordCloud",
      requestType = Wordcloud.WordCloudRequest.class,
      responseType = Wordcloud.WordCloudResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Wordcloud.WordCloudRequest,
      Wordcloud.WordCloudResponse> getGenerateWordCloudMethod() {
    io.grpc.MethodDescriptor<Wordcloud.WordCloudRequest, Wordcloud.WordCloudResponse> getGenerateWordCloudMethod;
    if ((getGenerateWordCloudMethod = WordCloudServiceGrpc.getGenerateWordCloudMethod) == null) {
      synchronized (WordCloudServiceGrpc.class) {
        if ((getGenerateWordCloudMethod = WordCloudServiceGrpc.getGenerateWordCloudMethod) == null) {
          WordCloudServiceGrpc.getGenerateWordCloudMethod = getGenerateWordCloudMethod =
              io.grpc.MethodDescriptor.<Wordcloud.WordCloudRequest, Wordcloud.WordCloudResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateWordCloud"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Wordcloud.WordCloudRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Wordcloud.WordCloudResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WordCloudServiceMethodDescriptorSupplier("GenerateWordCloud"))
              .build();
        }
      }
    }
    return getGenerateWordCloudMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WordCloudServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WordCloudServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WordCloudServiceStub>() {
        @java.lang.Override
        public WordCloudServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WordCloudServiceStub(channel, callOptions);
        }
      };
    return WordCloudServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WordCloudServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WordCloudServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WordCloudServiceBlockingStub>() {
        @java.lang.Override
        public WordCloudServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WordCloudServiceBlockingStub(channel, callOptions);
        }
      };
    return WordCloudServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WordCloudServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WordCloudServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WordCloudServiceFutureStub>() {
        @java.lang.Override
        public WordCloudServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WordCloudServiceFutureStub(channel, callOptions);
        }
      };
    return WordCloudServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void generateWordCloud(Wordcloud.WordCloudRequest request,
        io.grpc.stub.StreamObserver<Wordcloud.WordCloudResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateWordCloudMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WordCloudService.
   */
  public static abstract class WordCloudServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WordCloudServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WordCloudService.
   */
  public static final class WordCloudServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WordCloudServiceStub> {
    private WordCloudServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WordCloudServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WordCloudServiceStub(channel, callOptions);
    }

    /**
     */
    public void generateWordCloud(Wordcloud.WordCloudRequest request,
        io.grpc.stub.StreamObserver<Wordcloud.WordCloudResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateWordCloudMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WordCloudService.
   */
  public static final class WordCloudServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WordCloudServiceBlockingStub> {
    private WordCloudServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WordCloudServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WordCloudServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Wordcloud.WordCloudResponse generateWordCloud(Wordcloud.WordCloudRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateWordCloudMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WordCloudService.
   */
  public static final class WordCloudServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WordCloudServiceFutureStub> {
    private WordCloudServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WordCloudServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WordCloudServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Wordcloud.WordCloudResponse> generateWordCloud(
        Wordcloud.WordCloudRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateWordCloudMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_WORD_CLOUD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_WORD_CLOUD:
          serviceImpl.generateWordCloud((Wordcloud.WordCloudRequest) request,
              (io.grpc.stub.StreamObserver<Wordcloud.WordCloudResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGenerateWordCloudMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Wordcloud.WordCloudRequest,
              Wordcloud.WordCloudResponse>(
                service, METHODID_GENERATE_WORD_CLOUD)))
        .build();
  }

  private static abstract class WordCloudServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WordCloudServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Wordcloud.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WordCloudService");
    }
  }

  private static final class WordCloudServiceFileDescriptorSupplier
      extends WordCloudServiceBaseDescriptorSupplier {
    WordCloudServiceFileDescriptorSupplier() {}
  }

  private static final class WordCloudServiceMethodDescriptorSupplier
      extends WordCloudServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WordCloudServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WordCloudServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WordCloudServiceFileDescriptorSupplier())
              .addMethod(getGenerateWordCloudMethod())
              .build();
        }
      }
    }
    return result;
  }
}
