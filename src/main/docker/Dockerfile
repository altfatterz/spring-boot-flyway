FROM java:8
MAINTAINER altfatterz@gmail.com
ENV SPRING_PROFILES_ACTIVE docker
VOLUME /tmp
ADD spring-boot-flyway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
