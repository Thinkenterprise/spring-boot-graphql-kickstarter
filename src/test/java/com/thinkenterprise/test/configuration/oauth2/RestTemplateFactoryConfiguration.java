package com.thinkenterprise.test.configuration.oauth2;

import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Profile("OAuth2Security")
@Component
public class RestTemplateFactoryConfiguration {
	
	RestTemplateFactoryConfiguration(){
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
