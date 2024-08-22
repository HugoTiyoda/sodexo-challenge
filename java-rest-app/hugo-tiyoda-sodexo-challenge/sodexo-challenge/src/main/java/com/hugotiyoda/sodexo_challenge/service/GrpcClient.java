package com.hugotiyoda.sodexo_challenge.service;

import org.springframework.stereotype.Service;

import com.hugotiyoda.sodexo_challenge.grpc.Empty;
import com.hugotiyoda.sodexo_challenge.grpc.HelloWorldMessage;
import com.hugotiyoda.sodexo_challenge.grpc.HelloWorldServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class GrpcClient {
    private final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub;

    public GrpcClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        this.blockingStub = HelloWorldServiceGrpc.newBlockingStub(channel);
    }

    public String getMessage() {
        HelloWorldMessage response = blockingStub.getMessage(Empty.newBuilder().build());
        return response.getMessage();
    }
}