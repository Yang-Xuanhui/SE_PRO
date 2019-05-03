FROM java:8

MAINTAINER yangxh99

ADD wordladder-1.0-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app.jar"]
