package com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.tsf.annotation.EnableTsf;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableTsf
public class TsfSpringCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsfSpringCloudProviderApplication.class, args);
    }


}
