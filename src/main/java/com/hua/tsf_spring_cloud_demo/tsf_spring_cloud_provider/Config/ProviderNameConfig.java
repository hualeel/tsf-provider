package com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
//开启 refresh 机制
@RefreshScope
//注解来标明这个类是一个配置类
@ConfigurationProperties(prefix = "provider.config")
public class ProviderNameConfig {
    private String name = "env-test";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
