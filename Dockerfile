FROM eclipse-temurin:17

WORKDIR /app

COPY build/libs/CodeBench-0.0.1-SNAPSHOT.jar target.jar

ENTRYPOINT ["java","-jar","target.jar"]


