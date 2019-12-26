FROM java:8
LABEL maintainer="jhlee@lunasoft.co.kr"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/springboot-demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
