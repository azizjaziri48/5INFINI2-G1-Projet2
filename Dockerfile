FROM openjdk:11-jre-slim
WORKDIR /app
RUN apt-get update && apt-get install -y curl && curl -u admin:Ijnuhbygv123. -O http://192.168.30.10:8081/repository/maven-releases/tn/esprit/spring/kaddem/0.1/kaddem-0.1.jar
RUN apt-get remove -y curl && apt-get clean
EXPOSE 8083
CMD ["java", "-jar", "kaddem-1.0.jar"]