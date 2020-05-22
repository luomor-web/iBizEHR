
FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    IBZ_SLEEP=0 \
    JAVA_OPTS=""

CMD echo "The application will start in ${IBZ_SLEEP}s..." && \
    sleep ${IBZ_SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /ehr-app-ehrpcm2.jar

EXPOSE 8080

ADD ehr-app-ehrpcm2.jar /ehr-app-ehrpcm2.jar
