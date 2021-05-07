FROM rdomloge/graalvm-21.1.0-java11:multiarch AS build

RUN apt-get update
RUN apt-get install -y git wget

RUN mkdir repo 
WORKDIR /repo
RUN git clone https://github.com/rdomloge/catholicon-ms-club.git 
WORKDIR /repo/catholicon-ms-club
RUN wget --no-check-certificate https://mirrors.ukfast.co.uk/sites/ftp.apache.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz
RUN tar xzf apache-maven-3.8.1-bin.tar.gz
RUN rm apache-maven-3.8.1-bin.tar.gz
RUN ln -s apache-maven-3.8.1/bin/mvn mvn

RUN ./mvn -Dmaven.wagon.http.ssl.insecure=true -Dpackaging=native-image package


FROM ubuntu:hirsute
WORKDIR /
COPY --from=build /repo/catholicon-ms-club/application/target/catholicon-ms-club .

ENTRYPOINT ["/catholicon-ms-club"]