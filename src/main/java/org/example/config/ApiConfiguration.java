package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("usaa.ent.apis")
public class ApiConfiguration {
    private String apiKey;
    private Map<ApiName, Api> apiMap;

    @Data
    static class Api {
        private String domain;
        private String uri;
        private String glooEnvCookie;
        private String conjur;
    }
}
