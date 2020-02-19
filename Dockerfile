FROM 10.0.0.143:60080/alaudaorg/builder-java:openjdk8-v2.6.0-settings
ADD target/tsf-spring-cloud-provider-0.0.1-SNAPSHOT.jar /
EXPOSE 18081
CMD java -Dtsf_consul_ip=106.13.228.9 -Dtsf_consul_port=8500 -jar /tsf-spring-cloud-provider-0.0.1-SNAPSHOT.jar
