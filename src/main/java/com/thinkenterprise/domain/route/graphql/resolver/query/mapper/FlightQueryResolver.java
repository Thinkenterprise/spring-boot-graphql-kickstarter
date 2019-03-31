package com.thinkenterprise.domain.route.graphql.resolver.query.mapper;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.graphql.model.GraphQLFlight;
import com.thinkenterprise.domain.route.graphql.model.GraphQLRoute;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Profile("mapper")
@Component
public class FlightQueryResolver implements GraphQLResolver<GraphQLFlight> {
	
	
	public GraphQLRoute route(GraphQLFlight flight) {
		return flight.getRoute();
	}

}
