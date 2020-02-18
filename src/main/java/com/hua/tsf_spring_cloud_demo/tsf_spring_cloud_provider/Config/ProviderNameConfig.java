package com.hua.tsf_spring_cloud_demo.tsf_spring_cloud_provider.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
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
