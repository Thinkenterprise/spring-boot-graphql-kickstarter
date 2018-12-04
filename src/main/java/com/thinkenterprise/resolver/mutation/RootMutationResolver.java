package com.thinkenterprise.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.domain.route.RouteRepository;
import com.thinkenterprise.publisher.RouteUpdatePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RootMutationResolver implements GraphQLMutationResolver {

    RouteRepository routeRepository;

    RouteUpdatePublisher routeUpdatePublisher;

    @Autowired
    public RootMutationResolver(RouteRepository routeRepository,
                                RouteUpdatePublisher routeUpdatePublisher) {
        this.routeRepository=routeRepository;	
        this.routeUpdatePublisher=routeUpdatePublisher;
    }

    public Route createRoute(String flightNumber) {
        
        Route route = new Route(flightNumber);
        routeUpdatePublisher.emit(route);
        return routeRepository.save(route);

    }



}