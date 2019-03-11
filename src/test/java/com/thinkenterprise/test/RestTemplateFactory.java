package com.thinkenterprise.test;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory {
	
	RestTemplateFactory(){
		
	}
	
    @Bean
    public RestTemplateBuilder getRestTemplate() {
     	RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder(new CustomRestTemplateCustomizer());
    	return restTemplateBuilder;
    }

    public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {
        @Override
        public void customize(RestTemplate restTemplate) {
            restTemplate.getInterceptors().add(new AddHeaderInterceptor());
        }
    }
}
