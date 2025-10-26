FROM maven:3.9.2-eclipse-temurin-21

WORKDIR /app

COPY . /app

CMD ["mvn", "clean", "test"]
