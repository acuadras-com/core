FROM openjdk:8-jdk-alpine
EXPOSE 9072
ADD build/libs/tutendero-0.0.1-SNAPSHOT.jar tutendero.jar
ENTRYPOINT ["java", "-jar", "tutendero.jar"]