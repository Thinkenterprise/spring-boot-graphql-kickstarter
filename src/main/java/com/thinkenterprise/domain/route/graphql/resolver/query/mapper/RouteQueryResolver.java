package com.thinkenterprise.domain.route.graphql.resolver.query.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.graphql.model.GraphQLFlight;
import com.thinkenterprise.domain.route.graphql.model.GraphQLRoute;
import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.repository.FlightRepository;

import ma.glasnost.orika.MapperFacade;

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
public class RouteQueryResolver implements GraphQLResolver<GraphQLRoute> {

    private FlightRepository flightRepository;

    
    @Autowired
	private MapperFacade mapperFacade;
    
    
    public RouteQueryResolver() {
		super();
	}

	@Autowired
    public RouteQueryResolver(FlightRepository flightRepository) {
        this.flightRepository=flightRepository;
    }
       
	
    public List<GraphQLFlight> flights(GraphQLRoute route) {	
    	Route r = mapperFacade.map(route, Route.class);
    	return mapperFacade.mapAsList(flightRepository.findByRoute(r), GraphQLFlight.class);
    }
   
       

}