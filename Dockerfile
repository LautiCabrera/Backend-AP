FROM amazoncorretto:8-alpine-jdk 
MAINTAINER lautaro
COPY target/lau-0.0.1-SNAPSHOT.jar lau-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/lau-0.0.1-SNAPSHOT.jar"]
