package com.thinkenterprise.resolver.query;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.Flight;
import com.thinkenterprise.domain.route.Route;

@Component(FlightQueryResolver.ROOT_QUERY_RESOLVER)
public class FlightQueryResolver implements GraphQLResolver<Flight> {
	
	static final String ROOT_QUERY_RESOLVER = "com.thinkenterprise.resolver.query.FlightQueryResolver";
	
	public Route route(Flight flight) {	
		return flight.getRoute();
	}

}
