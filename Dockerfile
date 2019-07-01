# Multi stage Dockerfile inspired by https://github.com/justiandre/justiandre-exemplo-kotlin-paineltarefas/blob/master/Dockerfile

####################################################################################
# Imagem base das demais
####################################################################################

FROM azul/zulu-openjdk-alpine:11 AS base

WORKDIR /app

####################################################################################
# Imagem de build com maven
####################################################################################

FROM base AS build

ADD . .

ARG ADDITIONAL_TASK_MAVEN

RUN \
    ./mvnw clean install ${ADDITIONAL_TASK_MAVEN} && \
    mv target/*.jar app.jar

####################################################################################
# Imagem da execução da aplicação
####################################################################################

FROM base AS exec

COPY --from=build /app/app.jar app.jar

ARG PROFILES
ARG PORTs
ARG SPRING_PROFILES_ACTIVE
ARG JAVA_OPTS
ARG SERVER_PORT
ARG PATH_JAR

ENV SPRING_PROFILES_ACTIVE ${SPRING_PROFILES_ACTIVE:-${PROFILES:-default}}
ENV JAVA_OPTS ${JAVA_OPTS:-'-Xmx2g'}
ENV SERVER_PORT ${SERVER_PORT:-${PORT:-8080}}

EXPOSE ${SERVER_PORT}

CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar app.jar
