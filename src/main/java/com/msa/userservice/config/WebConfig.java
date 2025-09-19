package com.msa.userservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WebConfig {

    @Value("${client.point-service.url}")
    private String pointServiceUrl;

    @Bean(name = "pointRestClient")
    public RestClient pointServiceRestClient() {
        return RestClient.builder()
                .baseUrl(pointServiceUrl)
                .build();
    }

}
