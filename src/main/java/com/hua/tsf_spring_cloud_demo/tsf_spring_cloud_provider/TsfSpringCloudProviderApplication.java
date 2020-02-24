package com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.tsf.annotation.EnableTsf;

@SpringBootApplication
@EnableTsf
public class TsfSpringCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsfSpringCloudProviderApplication.class, args);
    }


}
