FROM openjdk:11
LABEL Gabriel Carvalho
VOLUME /tmp
ADD ./target/microservico-0.0.1-SNAPSHOT.jar microservico.jar
ENTRYPOINT [ "java","-jar", "/microservico.jar" ]
EXPOSE 8080 