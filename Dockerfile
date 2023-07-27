# Use a base image with Java and Maven installed
FROM maven:3.9.3-eclipse-temurin-20 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project's pom.xml and download dependencies
COPY pom.xml .

# Download the project dependencies (this step is cached if the pom.xml file hasn't changed)
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the Spring Boot application
RUN mvn package -DskipTests

# Use a minimal base image with Java only
FROM openjdk:19-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built application from the previous stage
COPY --from=builder /app/target/StudentSurvey-0.0.1-SNAPSHOT.jar ./StudentSurvey.jar

# Expose the port your Spring Boot application is running (set in application.properties)
EXPOSE 8082

# Command to run your application
CMD ["java", "-jar",  "StudentSurvey.jar"]