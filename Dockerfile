FROM openjdk:17
COPY build/libs/users-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5000
CMD ["java","-jar","app.jar"]