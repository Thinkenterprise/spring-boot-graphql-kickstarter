package com.thinkenterprise.domain.route.graphql.resolver.query.mapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.graphql.model.GraphQLFlight;
import com.thinkenterprise.domain.route.graphql.model.GraphQLRoute;
import com.thinkenterprise.domain.route.jpa.model.Flight;
import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.repository.FlightRepository;
import com.thinkenterprise.util.KeyUtils;

import graphql.schema.DataFetchingEnvironment;
import ma.glasnost.orika.MapperFacade;

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
    	return mapperFacade.mapAsList(flightRepository.findByRoute(route.getId()), GraphQLFlight.class);
    }
   
    
 
	/*
    public CompletableFuture<List<Flight>> flights(Route route, DataFetchingEnvironment dataFetchingEnvironment) {  
    	DataLoader<Long,Flight> dataLoader = dataFetchingEnvironment.getDataLoader("flight");
    	return dataLoader.loadMany(KeyUtils.getKeys(route.getId()));
    }
  */
    

}