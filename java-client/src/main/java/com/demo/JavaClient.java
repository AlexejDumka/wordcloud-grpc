package com.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
public class JavaClient
{
    private static final Logger logger = Logger.getLogger(JavaClient.class.getName());
    public static void main( String[] args )
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("python-server", 50051)
                .usePlaintext()
                .build();

        WordCloudServiceGrpc.WordCloudServiceBlockingStub stub = WordCloudServiceGrpc.newBlockingStub(channel);

        String text = "Java VMware Hyper-V Docker Kubernetes Jenkins DEVOPS Python C# Java Jakarta, Spring Quarkus Java Kotlin Jakarta grpc virtualization container orchestration, DEVOPS CI/CD";

        Wordcloud.WordCloudRequest request = Wordcloud.WordCloudRequest.newBuilder()
                .setText(text)
                .build();

        try {
            Wordcloud.WordCloudResponse response = stub.generateWordCloud(request);
            saveImage(response.getImage().toByteArray(), "wordcloud.png");
            logger.info("Word cloud image received and saved as wordcloud.png");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to generate word cloud: " + e.getMessage(), e);
        } finally {
            channel.shutdown();
        }
    }
    private static void saveImage(byte[] imageBytes, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(imageBytes);
            logger.info("Image saved successfully: " + fileName);
        }
    }

}
