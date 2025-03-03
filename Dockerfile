FROM openjdk:17

EXPOSE 8070

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java" , "-jar", "/app.jar"]
