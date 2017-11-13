package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hutingcong on 2017/10/31.
 */
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectUrlConfig {
    private String sell;

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }
}
