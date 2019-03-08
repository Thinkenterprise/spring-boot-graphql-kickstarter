package com.thinkenterprise.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("OAuth2")
public class GraphQLOAuth2JWTWebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
	}
	
}
