package com.thinkenterprise.resolver.query;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.Flight;
import com.thinkenterprise.domain.route.FlightRepository;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.util.KeyUtils;

import graphql.schema.DataFetchingEnvironment;

@Component(RouteQueryResolver.ROOT_QUERY_RESOLVER)
public class RouteQueryResolver implements GraphQLResolver<Route> {

	static final String ROOT_QUERY_RESOLVER = "com.thinkenterprise.resolver.query.RouteQueryResolver";
    private FlightRepository flightRepository;

    public RouteQueryResolver() {
		super();
	}

	@Autowired
    public RouteQueryResolver(FlightRepository flightRepository) {
        this.flightRepository=flightRepository;
    }
       
	/*
    public List<Flight> flights(Route route) {
    	return flightRepository.findbyRoute(route.getId());
    }
   */
    
 
    public CompletableFuture<List<Flight>> flights(Route route, DataFetchingEnvironment dataFetchingEnvironment) {  
    	DataLoader<Long,Flight> dataLoader = dataFetchingEnvironment.getDataLoader("flight");
    	return dataLoader.loadMany(KeyUtils.getKeys(route.getId()));
    }
  
    

}