FROM openjdk:8
EXPOSE 8083
ADD target/5INIFINI2-G1-Projet2.jar 5INIFINI2-G1-Projet2.jar
ENTRYPOINT ["java", "-jar", "/5INIFINI2-G1-Projet2.jar"]
