package com.thinkenterprise.domain.route.graphql.resolver.query.mapper;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.graphql.model.GraphQLFlight;
import com.thinkenterprise.domain.route.graphql.model.GraphQLRoute;
import com.thinkenterprise.domain.route.jpa.model.Flight;
import com.thinkenterprise.domain.route.jpa.model.Route;

@Profile("mapper")
@Component
public class FlightQueryResolver implements GraphQLResolver<GraphQLFlight> {
	
	
	public GraphQLRoute route(GraphQLFlight flight) {
		return null;
		//return flight.getRoute();
	}

}
