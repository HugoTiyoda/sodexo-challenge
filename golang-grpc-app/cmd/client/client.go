package main

import (
	"context"
	"log"
	"time"

	pb "github.com/hugotiyoda/hugo-tiyoda-sodexo-challenge/proto"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

func main() {
	conn, err := grpc.Dial("localhost:50051", grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		log.Fatalf("não conectou: %v", err)
	}
	defer conn.Close()

	c := pb.NewHelloWorldServiceClient(conn)

	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()

	r, err := c.GetMessage(ctx, &pb.Empty{})
	if err != nil {
		log.Fatalf("could not greet: %v", err)
	}
	log.Printf("Message: %s", r.GetMessage())
}
