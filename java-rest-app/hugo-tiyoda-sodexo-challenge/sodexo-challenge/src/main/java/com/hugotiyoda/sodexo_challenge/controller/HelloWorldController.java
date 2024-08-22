package com.hugotiyoda.sodexo_challenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugotiyoda.sodexo_challenge.service.GrpcClient;

@RestController
public class HelloWorldController {
    private final GrpcClient grpcClient;

    public HelloWorldController(GrpcClient grpcClient) {
        this.grpcClient = grpcClient;
    }

    @GetMapping("/helloWorld")
    public HelloWorldResponse getHelloWorld() {
        String message = grpcClient.getMessage();
        return new HelloWorldResponse(message);
    }

    private static class HelloWorldResponse {
        private final String message;

        public HelloWorldResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}