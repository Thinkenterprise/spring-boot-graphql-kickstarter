package com.thinkenterprise.resolver.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.domain.route.RouteRepository;
import com.thinkenterprise.error.RouteException;
import com.thinkenterprise.error.RouteGraphQLError;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;

@Component(RootQueryResolver.ROOT_QUERY_RESOLVER)
public class RootQueryResolver implements GraphQLQueryResolver {

	static final String ROOT_QUERY_RESOLVER = "com.thinkenterprise.resolver.query.RootQueryResolver";
	private RouteRepository routeRepository;
	
	@Autowired
	public RootQueryResolver(RouteRepository routeRepository) {
		this.routeRepository=routeRepository;	
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	//@PreAuthorize("#oauth2.hasScope('random')")
	public List<Route> routes() {
		return routeRepository.findAll();
	} 

	@ExceptionHandler(RouteException.class)
	public GraphQLError exception(RouteException routeException) {
		return new RouteGraphQLError(routeException.getMessage());
	}
	

}
