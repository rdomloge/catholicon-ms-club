FROM findepi/graalvm:java11

RUN apt-get update
RUN apt-get install -y git wget

COPY downloads/native-image-installable-svm-java11-linux-amd64-21.0.0.2.jar .

RUN gu -L install native-image-installable-svm-java11-linux-amd64-21.0.0.2.jar

RUN java -version
RUN mkdir repo 
WORKDIR /repo
RUN git clone https://github.com/rdomloge/catholicon-ms-club.git 
WORKDIR /repo/catholicon-ms-club 
RUN wget --no-check-certificate https://mirrors.ukfast.co.uk/sites/ftp.apache.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz
RUN tar xzf apache-maven-3.8.1-bin.tar.gz
RUN ln -s apache-maven-3.8.1/bin/mvn mvn
RUN ./mvn -Pgraalvm -Dmaven.wagon.http.ssl.insecure=true -Dpackaging=docker-native package
RUN ls -l ./application/target
RUN cp ./application/target/catholicon-ms-club.jar /
RUN rm -r repo

ENTRYPOINT ["java", "-jar", "catholicon-ms-club.jar"]