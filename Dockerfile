FROM anapsix/alpine-java:jdk8

ADD ./target/demo*.jar /opt/demo.jar

ENTRYPOINT ["/opt/jdk/bin/java","-jar","/opt/demo.jar"]

