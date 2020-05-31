
FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBIZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${IBIZ_SLEEP}s..." && \
    sleep ${IBIZ_SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /ehr-app-ehrpim.jar

EXPOSE 36092

ADD ehr-app-ehrpim.jar /ehr-app-ehrpim.jar
