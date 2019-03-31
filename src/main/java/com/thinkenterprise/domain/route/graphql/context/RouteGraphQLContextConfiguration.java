package com.thinkenterprise.domain.route.graphql.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import graphql.servlet.GraphQLContextBuilder;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Configuration
@Profile("context")
public class RouteGraphQLContextConfiguration {
	
	@Bean
	public GraphQLContextBuilder graphQLContextBuilder() {
		return new RouteGraphQLContextBuilder("345#FD");	
	}

}