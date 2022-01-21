FROM openjdk:11

ARG COURSE_API_FILE_JAR=./build/libs/course-api-0.0.1-SNAPSHOT.jar
COPY ${COURSE_API_FILE_JAR} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
