# Runtime image for the Temperature Converter application.
# Maven builds the executable jar first (mvn clean install / package),
# then this Dockerfile copies that jar in. It expects
# target/temperature-converter.jar to exist (finalName in pom.xml).

FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the executable jar produced by Maven
COPY target/temperature-converter.jar app.jar

# Run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
