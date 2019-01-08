package com.thinkenterprise.resolver.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.domain.route.RouteRepository;
import com.thinkenterprise.error.RouteException;
import com.thinkenterprise.error.RouteGraphQLError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLError;

@Component(RootQueryResolver.ROOT_QUERY_RESOLVER)
public class RootQueryResolver implements GraphQLQueryResolver {

	static final String ROOT_QUERY_RESOLVER = "com.thinkenterprise.resolver.query.RootQueryResolver";
	private RouteRepository routeRepository;
	
	@Autowired
	public RootQueryResolver(RouteRepository routeRepository) {
		this.routeRepository=routeRepository;	
	}
	
	public List<Route> routes() {
		throw new RouteException("My Own Exception");
		//return routeRepository.findAll();
	} 

	@ExceptionHandler(RouteException.class)
	public GraphQLError exception(RouteException routeException) {
		return new RouteGraphQLError(routeException.getMessage());
	}
	

}
