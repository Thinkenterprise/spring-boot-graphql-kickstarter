package com.thinkenterprise.domain.route.graphql.resolver.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.jpa.model.Flight;
import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.repository.FlightRepository;
import com.thinkenterprise.domain.route.jpa.repository.RouteRepository;

@Profile("!mapper")
@Component(value=FlightQueryResolver.ROOT_QUERY_RESOLVER)
public class FlightQueryResolver implements GraphQLResolver<Flight> {
	
	static final String ROOT_QUERY_RESOLVER = "com.thinkenterprise.domain.route.graphql.resolver.query.FlightQueryResolver";
	
	private RouteRepository routetRepository;
	
	@Autowired
	public FlightQueryResolver(RouteRepository routetRepository) {
		super();
		this.routetRepository = routetRepository;
	}

	public FlightQueryResolver() {
		super();
	}
	
	public Route route(Flight flight) {	
		
		return routetRepository.findById(flight.getRoute().getId()).get();
		
		
		//return routetRepository.findByFlight(flight.getId()).iterator().next();
		// If we have already loaded the references eager, no access to the repository is necessary
		//return flight.getRoute();
	}
}
