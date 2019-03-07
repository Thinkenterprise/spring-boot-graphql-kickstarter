package com.thinkenterprise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.thinkenterprise.context.RouteGraphQLContextBuilder;

import graphql.servlet.GraphQLContextBuilder;

@Configuration
@Profile("withContext")
public class GraphQLConfiguration {
	
	@Bean
	public GraphQLContextBuilder graphQLContextBuilder() {
		return new RouteGraphQLContextBuilder("345#FD");	
	}

}