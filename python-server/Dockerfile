# Use the official Python image as the base
FROM python:3.12-slim

# Set the working directory
WORKDIR /app

# Copy the files
COPY python-server/server.py .
COPY python-server/wordcloud_pb2.py .
COPY python-server/wordcloud_pb2_grpc.py .

# Install required Python packages
RUN pip install grpcio grpcio-tools wordcloud pillow

# Expose the gRPC server port
EXPOSE 50051

# Run the server
CMD ["python", "server.py"]
