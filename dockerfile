FROM openjdk:17-jdk-alpine

RUN mkdir /files

COPY target/SpringBootMail-0.0.1-SNAPSHOT.jar SpringBoot_Mail.jar

RUN chmod -R 777 /files

WORKDIR /

ENTRYPOINT ["java", "-jar", "/SpringBoot_Mail.jar"]