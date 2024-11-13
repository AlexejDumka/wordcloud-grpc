# Use OpenJDK 11 as the base image
 FROM maven:3.8.1-openjdk-11-slim AS builder

# Set the working directory
 WORKDIR /app

# Copy the pom file
 COPY java-client/pom.xml .
 
# Resolves project dependencies
 RUN mvn dependency:go-offline -B

# Copy sources
 COPY java-client/src ./src

# bundles all the JARs into one executable JAR.  
 RUN mvn clean compile assembly:single

# Use a slim JRE image to run the client
 FROM openjdk:11-jre-slim

# Set the working directory
 WORKDIR /app

# Copy the built jar file from the builder stage
 COPY --from=builder /app/target/java-client-1.0-SNAPSHOT-jar-with-dependencies.jar client.jar

# Run the Java client
 CMD ["java", "-jar", "client.jar"]
