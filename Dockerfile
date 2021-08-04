FROM maven:3.6.3-jdk-11-slim

WORKDIR /usr/src

COPY . .

RUN mvn -f /usr/src/pom.xml clean package

ENTRYPOINT ["java","-jar","target/builders-test-0.1-SNAPSHOT.jar"]
