FROM maven:3.9.5-amazoncorretto-21-al2023 AS build
WORKDIR /home/app

COPY ./pom.xml /home/app/pom.xml
COPY ./src /home/app/src

RUN mvn -f /home/app/pom.xml clean package -DskipTests

COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]