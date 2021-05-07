FROM ubuntu:hirsute AS base

ARG ARCH

RUN apt-get update
RUN apt-get install -y git wget

RUN wget --no-check-certificate https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-21.1.0/graalvm-ce-java11-linux-${ARCH}-21.1.0.tar.gz
RUN tar xzf graalvm-ce-java11-linux-${ARCH}-21.1.0.tar.gz
RUN rm graalvm-ce-java11-linux-${ARCH}-21.1.0.tar.gz

ENV PATH=/graalvm-ce-java11-21.1.0/bin:$PATH

RUN wget --no-check-certificate https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-21.1.0/native-image-installable-svm-java11-linux-${ARCH}-21.1.0.jar
RUN gu -L install native-image-installable-svm-java11-linux-${ARCH}-21.1.0.jar
RUN rm native-image-installable-svm-java11-linux-${ARCH}-21.1.0.jar



FROM ubuntu:hirsute

RUN apt-get update
RUN apt-get install -y build-essential libz-dev zlib1g-dev

COPY --from=base /graalvm-ce-java11-21.1.0 /graalvm-ce-java11-21.1.0
ENV PATH=/graalvm-ce-java11-21.1.0/bin:$PATH
ENV JAVA_HOME=/graalvm-ce-java11-21.1.0