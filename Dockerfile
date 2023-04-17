FROM amazoncorretto:11-alpine-jdk 
MAINTAINER lautaro
COPY target/lau-0.0.1-SNAPSHOT.jar  lau-app.jar
ENTRYPOINT ["java","-jar","/lau-app.jar"]
