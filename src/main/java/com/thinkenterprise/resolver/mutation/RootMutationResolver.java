package com.thinkenterprise.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.domain.route.RouteRepository;
import com.thinkenterprise.error.RouteException;
import com.thinkenterprise.publisher.RouteCreatePublisher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RootMutationResolver implements GraphQLMutationResolver {

    RouteRepository routeRepository;

    RouteCreatePublisher routeUpdatePublisher;

    @Autowired
    public RootMutationResolver(RouteRepository routeRepository,
                                RouteCreatePublisher routeUpdatePublisher) {
        this.routeRepository=routeRepository;	
        this.routeUpdatePublisher=routeUpdatePublisher;
    }

    public Route createRoute(String flightNumber) {
        
        Route route = new Route();
        route.setFlightNumber(flightNumber);
        routeUpdatePublisher.emit(route);
        return routeRepository.save(route);

    }
    
    public Route updateRoute(Long id, Boolean disabled) {
    	Optional<Route> route = routeRepository.findById(id);
    	if(route.isPresent()) {
    		route.get().setDisabled(disabled);
    		routeUpdatePublisher.emit(route.get());
    		return routeRepository.save(route.get());
    	}
    	throw new RouteException("route not found");
    }
    
    public Boolean deleteRoute(Long id) {
    	Optional<Route> route = routeRepository.findById(id);
    	if(route.isPresent()) {
    		routeRepository.delete(route.get());
    		return Boolean.TRUE;
    	}
    	return Boolean.FALSE;
    }



}