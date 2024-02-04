FROM openjdk:8
EXPOSE 8083
ADD target/5infini2-g1-projet2-1.0.jar 5infini2-g1-projet2-1.0.jar
ENTRYPOINT ["java", "-jar", "/5infini2-g1-projet2-1.0.jar"]
