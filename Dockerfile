FROM ubuntu:22.04

RUN apt update && apt upgrade -y

RUN apt install -y \
    curl \
    vim \
    wget \
    zip

RUN apt install -y openjdk-19-jdk

RUN wget -c https://services.gradle.org/distributions/gradle-7.6-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-7.6-bin.zip

ENV GRADLE_HOME=/opt/gradle/gradle-7.6
ENV PATH=${GRADLE_HOME}/bin:${PATH}
