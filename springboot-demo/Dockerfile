FROM openjdk:8-jdk-alpine
VOLUME /tmp

RUN apk --no-cache add unzip
COPY pinpoint-agent-1.8.5.zip pinpoint.zip
RUN unzip -oq pinpoint.zip -d ./

COPY springboot-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-javaagent:/pinpoint-bootstrap-1.8.5.jar","-Dpinpoint.agentId=springboot.service01","-Dpinpoint.applicationName=springboot-demo","-jar","/app.jar"]
#ENTRYPOINT ["java","-jar","/app.jar"]
