package main

import (
	"context"
	"log"
	"net"

	pb "github.com/hugotiyoda/hugo-tiyoda-sodexo-challenge/proto"

	"google.golang.org/grpc"
)

type server struct {
	pb.UnimplementedHelloWorldServiceServer
}

func (s *server) GetMessage(ctx context.Context, in *pb.Empty) (*pb.HelloWorldMessage, error) {
	return &pb.HelloWorldMessage{Message: "Hello World"}, nil
}

func main() {
	lis, err := net.Listen("tcp", ":50051")
	if err != nil {
		log.Fatalf("falha ao escutar: %v", err)
	}
	s := grpc.NewServer()
	pb.RegisterHelloWorldServiceServer(s, &server{})
	log.Printf("servidor gRPC na porta %v", lis.Addr())
	if err := s.Serve(lis); err != nil {
		log.Fatalf("falha ao executar: %v", err)
	}
}
