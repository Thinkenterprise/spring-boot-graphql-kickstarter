package com.thinkenterprise.domain.route.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.repository.RouteRepository;

@RestController
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @GetMapping("routes")
    public Iterable<Route> routes() {
        return routeRepository.findAll();
    }
    
}