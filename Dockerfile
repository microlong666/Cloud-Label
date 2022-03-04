FROM openjdk:17
MAINTAINER microloong
VOLUME /www/wwwroot/cloud-label
ADD target/cloudLabel-0.0.1-SNAPSHOT.jar cloudLabel.jar
RUN bash -c "touch /cloudLabel.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","cloudLabel.jar"]