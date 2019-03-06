package com.thinkenterprise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thinkenterprise.context.RouteGraphQLContextBuilder;

import graphql.servlet.GraphQLContextBuilder;

@Configuration
public class GraphQLConfiguration {
	
	@Bean
	public GraphQLContextBuilder graphQLContextBuilder() {
		
		return new RouteGraphQLContextBuilder("MyToken");
		
		
	}

}
