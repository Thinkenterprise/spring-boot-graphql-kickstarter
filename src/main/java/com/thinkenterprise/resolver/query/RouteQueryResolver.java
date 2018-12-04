package com.thinkenterprise.resolver.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.Flight;
import com.thinkenterprise.domain.route.FlightRepository;
import com.thinkenterprise.domain.route.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteQueryResolver implements GraphQLResolver<Route> {

    private FlightRepository flightRepository;

    @Autowired
    public RouteQueryResolver(FlightRepository flightRepository) {
        this.flightRepository=flightRepository;
    }

    public List<Flight> flights() {
        return flightRepository.findAll();
    }

}