package com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider;

import com.tencent.tsf.monitor.annotation.EnableTsfMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.tsf.annotation.EnableTsf;
import org.springframework.tsf.auth.annotation.EnableTsfAuth;

@SpringBootApplication
@EnableTsf
//服务监控
@EnableTsfMonitor
//服务鉴权
@EnableTsfAuth
public class TsfSpringCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsfSpringCloudProviderApplication.class, args);
    }


}
