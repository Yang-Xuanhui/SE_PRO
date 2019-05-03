FROM java:8

MAINTAINER yangxh99

ADD login-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8099

ENTRYPOINT ["java","-jar","/app.jar"]
