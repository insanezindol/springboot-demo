FROM openjdk:8-jdk-alpine
VOLUME /tmp

RUN apk --no-cache add tar
#COPY http://172.31.3.130:28080/agent/pinpoint-agent-1.8.5.tar.gz /opt/pinpoint/pinpoint.tar.gz
COPY pinpoint-agent-1.8.5.tar.gz pinpoint.tar.gz
RUN tar -zxvf pinpoint.tar.gz

ADD springboot-demo-0.0.1-SNAPSHOT.jar app.jar

ENV JAVA_OPTS="-javaagent:/pinpoint-agent/pinpoint-bootstrap-1.8.5.jar -Dpinpoint.agentId=springboot.service00 -Dpinpoint.applicationName=springboot-demo"

ENTRYPOINT exec java ${JAVA_OPTS} -jar app.jar