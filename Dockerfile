FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9000
ADD target/backend-rest-interseguro-0.0.1-SNAPSHOT.jar backend-rest.jar
ENTRYPOINT ["java","-jar","/backend-rest.jar"]