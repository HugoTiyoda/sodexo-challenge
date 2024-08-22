# Iniciando servidor golang

Navegar até cmd/server  
rodar go run server.go

# Iniciando o projeto java 
###  Buildando o JAR  
Navegar até a raiz do projeto, executar ```mvn package``` e verificar se na pasta target foi gerado o .jar

### Executando
Após feito o executavel do projeto:  
```java -jar target/sodexo-challenge-0.0.1-SNAPSHOT.jar.jar```

# Consultando 

O host java foi definido como local padrão, na porta 8080,
enquanto o servidor grpc foi definido também em sua porta padrão, 50051.

O endpoint de acesso, via rest é ```localhost:8080/helloWorld```
