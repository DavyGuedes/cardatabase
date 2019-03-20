FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/cardatabase-0.0.1-SNAPSHOT.jar cardatabase.jar
EXPOSE 8080
#ENTRYPOINT exec java $JAVA_OPTS -jar cardatabase.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar cardatabase.jar
