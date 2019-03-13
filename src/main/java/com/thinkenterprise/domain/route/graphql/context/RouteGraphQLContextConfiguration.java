package com.thinkenterprise.domain.route.graphql.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import graphql.servlet.GraphQLContextBuilder;

@Configuration
@Profile("context")
public class RouteGraphQLContextConfiguration {
	
	@Bean
	public GraphQLContextBuilder graphQLContextBuilder() {
		return new RouteGraphQLContextBuilder("345#FD");	
	}

}