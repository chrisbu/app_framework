# java11 prebuilt alpine linux
FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /opt/app

# copy local jar file to docker
ARG LOCAL_JAR_FILE=target/learning_log-0.0.1-SNAPSHOT.jar
ARG DOCKER_JAR_FILE=app.jar
COPY ${JAR_FILE} ${DOCKER_JAR_FILE}

ENTRYPOINT ["java","-jar", ${DOCKER_JAR_FILE}]




