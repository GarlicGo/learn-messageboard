FROM openjdk:17.0.2
COPY target/messageboard-0.0.1-SNAPSHOT.jar /application.jar
EXPOSE 8080
ENV TZ Asia/Shanghai
ENTRYPOINT ["java","-jar","/application.jar","--spring.profiles.active=production"]