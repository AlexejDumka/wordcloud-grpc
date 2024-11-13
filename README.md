# Word Cloud Generator with Java Client and Python Server
This project demonstrates a Java client interacting with a Python server over gRPC to generate word cloud images. The primary purpose is to showcase the Java clientвЂ™s ability to connect with a Python server, send text input, and handle the returned word cloud image.
The Java client sends a text string to the Python server via gRPC. The server processes the text, creates a word cloud image, and returns it in PNG format. The client then saves this image locally.

## Project Structure

```
wordcloud-grpc
     |-- java-client
     |-- python-server 
     |-- README.md
     |-- docker-compose.yml 
```
## Key Features
 - **Java Client Demonstration**: The Java client showcases cross-language communication with a Python server using gRPC.
 - **Word Cloud Generation**: The server generates a word cloud image based on text input from the client.
 - **Error Handling and Logging**: Both applications include error handling and logging for easy debugging.
 - **Docker Support**: Both the client and server are containerized and can be orchestrated with Docker Compose.

##    Prerequisites

*    Java 11 or higher (for the Java client)
*    Python 3.9 or higher (for the Python server)
*    Docker and Docker Compose (optional, for running in containers)

## Setup

Clone the Repository
```
git clone https://github.com/AlexejDumka/workloud-grpc.git
cd wordcloud-grpc
```
   
Build and Run with Docker Compose
   To simplify running both applications together, use Docker Compose:

```
docker-compose up --build
```

This command will:

 - Build and start the Python server, which listens on port 50051 for incoming gRPC requests.
 - Build and start the Java client, which sends text data to the server and saves the word cloud image.
 - Running Standalone Containers.
   
If you prefer to run the containers separately, you can build and run them using the following commands:

Python Server:

```
docker build -t python-server ./python-server
docker run -d --name python-server -p 50051:50051 python-server
```

Java Client:

```
docker build -t java-client ./java-client
docker run --name java-client --network=wordcloud-grpc_wordcloud-network java-client
```
docker build -t java-client ./java-client
docker run --name java-client --network=wordcloud-grpc_wordcloud-network java-client

## Detailed Setup (Without Docker)

If you prefer to run each application separately, follow the instructions below.

### Python Server Setup

Navigate to the python-server directory:

```
cd python-server
```

Install dependencies (if necessary):

```
pip install -r requirements.txt
```

Generate gRPC Code for Python (if necessary): 


```python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. wordcloud.proto```

Run the server:
```python server.py```

### Java Client Setup

Navigate to the java-client directory:
```
cd java-client
```

Generate gRPC Code for Java (if necessary):
```
protoc --java_out=./java-client/src/main/java --grpc-java_out=./java-client/src/main/java wordcloud.proto
```

Assembly the client with Maven:
 
```
mvn clean assembly:single
```

Run the client:

```
java -jar target/java-client-1.0-SNAPSHOT-jar-with-dependencies.jar
```
## Configuration

The default hostname and port for gRPC communication are configured to work with Docker Compose. If running without Docker, ensure the client connects to the correct hostname and port of the Python server.

## Troubleshooting

 - Connection Issues: If the Java client cannot connect to the server, ensure the server is running and accessible at the configured hostname and port (default: python-server:50051 in Docker).
 - SLF4J Warnings: If the Java client logs SLF4J warnings, ensure SLF4J and Logback dependencies are correctly set up in pom.xml.
 - gRPC Code Generation: If the server is missing gRPC files, regenerate them as described above.
