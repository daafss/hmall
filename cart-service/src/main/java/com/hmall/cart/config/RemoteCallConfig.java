package com.hmall.cart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: violet
 * Date: 2024/8/26 14:55
 */
@Configuration
public class RemoteCallConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
