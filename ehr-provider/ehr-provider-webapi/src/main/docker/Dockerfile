
FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${IBZ_SLEEP}s..." && \
    sleep ${IBZ_SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /ehr-provider-webapi.jar

EXPOSE 35080

ADD ehr-provider-webapi.jar /ehr-provider-webapi.jar
