#base images
FROM 10.0.0.143:60080/alaudaorg/builder-java:openjdk8-v2.6.0-settings

# COPY File
COPY target/tsf-spring-cloud-provider-0.0.1-SNAPSHOT.jar /data/tsf
COPY run.sh /data/tsf

# GMT+8 for CentOS
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai"> /etc/timezone

# PORT
EXPOSE 18081

# run.sh
#CMD java -Dtsf_consul_ip=106.13.228.9 -Dtsf_consul_port=8500 -jar /data/tsf/tsf-spring-cloud-provider-0.0.1-SNAPSHOT.jar
CMD ["sh", "-c", "cd /data/tsf; sh run.sh tsf-spring-cloud-provider-0.0.1-SNAPSHOT.jar /data/tsf"]
