# Use the official OpenJDK base image  
FROM openjdk:17-jdk-slim as builder  

# Set the working directory inside the container  
WORKDIR /app  

# Copy the Gradle wrapper and build files  
COPY gradlew .  
COPY gradle /app/gradle  
COPY build.gradle .  
COPY settings.gradle .  

# Copy the source code  
COPY src ./src  

# Grant execution permission to the Gradle wrapper script  
RUN chmod +x gradlew  

# Build the project  
RUN ./gradlew build -x test  

# Create a final image  
FROM openjdk:17-jdk-slim  

# Set the working directory for the final image  
WORKDIR /app  

# Copy the built JAR file from the builder stage  
COPY --from=builder /app/build/libs/*.jar app.jar  

# Expose the application port (default Spring Boot port)  
EXPOSE 8080  

# Run the application  
ENTRYPOINT ["java", "-jar", "app.jar"]