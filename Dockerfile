FROM maven:3.9.2-eclipse-temurin-17
WORKDIR /app
COPY . /app
RUN mvn clean install
