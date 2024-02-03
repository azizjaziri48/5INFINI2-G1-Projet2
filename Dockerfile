FROM openjdk:8
EXPOSE 8080
ADD kaddem/kaddem-1.0.jar kaddem-1.0.jar
ENTRYPOINT ["java", "-jar", "/kaddem-1.0.jar"]