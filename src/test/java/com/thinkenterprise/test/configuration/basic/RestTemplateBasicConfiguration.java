package com.thinkenterprise.test.configuration.basic;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("basicSecurity")
public class RestTemplateBasicConfiguration {
	 
    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder().basicAuthentication("user", "password");
    }
    
}

