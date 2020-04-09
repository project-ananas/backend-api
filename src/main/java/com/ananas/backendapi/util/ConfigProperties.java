package com.ananas.backendapi.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

    @Configuration
    @ConfigurationProperties(prefix = "gateway")
public class ConfigProperties {

    private int time;
    private String url;
    private boolean debug;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public int getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}