FROM findepi/graalvm:java11

RUN apt-get update
RUN apt-get install -y git wget
RUN echo -n | openssl s_client -connect www.graalvm.org:443 | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > graalvm.org.cert
RUN keytool  -importcert -storepass 'changeit'  -v -alias kubuntu -file graalvm.org.cert -keystore jre/lib/security/cacerts
RUN gu install native-image

RUN java -version
RUN mkdir repo 
WORKDIR /repo
RUN git clone https://github.com/rdomloge/catholicon-ms-club.git 
WORKDIR /repo/catholicon-ms-club 
RUN wget --no-check-certificate https://mirrors.ukfast.co.uk/sites/ftp.apache.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz
RUN tar xzf apache-maven-3.8.1-bin.tar.gz
RUN ln -s apache-maven-3.8.1/bin/mvn mvn
RUN ./mvn -Dmaven.wagon.http.ssl.insecure=true package -Dpackaging=docker-native
RUN ls -l ./application/target
RUN cp ./application/target/catholicon-ms-club.jar /
RUN rm -r repo

ENTRYPOINT ["java", "-jar", "catholicon-ms-club.jar"]