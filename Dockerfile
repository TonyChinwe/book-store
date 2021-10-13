FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG STATE_FILE=target/*.txt
COPY ${JAR_FILE} app.jar
COPY ${STATE_FILE} states.txt
ENTRYPOINT ["java","-jar","/app.jar"]