package com.thinkenterprise.domain.route.graphql.resolver.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thinkenterprise.domain.route.RouteException;
import com.thinkenterprise.domain.route.graphql.error.RouteGraphQLError;
import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.repository.RouteRepository;

import graphql.GraphQLError;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Profile("!mapper")
@Component(RootQueryResolver.ROOT_QUERY_RESOLVER)
public class RootQueryResolver implements GraphQLQueryResolver {

	static final String ROOT_QUERY_RESOLVER = "com.thinkenterprise.domain.route.graphql.resolver.query.RootQueryResolver";
	private RouteRepository routeRepository;
	
	@Value("${route.exception}")
	private Boolean exception; 
	
	
	public RootQueryResolver() {
		super();
	}

	@Autowired
	public RootQueryResolver(RouteRepository routeRepository) {
		this.routeRepository=routeRepository;	
	}
	
	// Enable if Profile basicSecurity is enabled @PreAuthorize("hasRole('read')")
	// Enable if Profile OAuth2Security is enabled @PreAuthorize("#oauth2.hasScope('read')")
	// Enable if Profile context is enabled public List<Route> routes(DataFetchingEnvironment dataFetchingEnvironment) {
	//                                        System.out.println(dataFetchingEnvironment.getContext().toString());
	public List<Route> routes() {
		
		if(!exception)
			return routeRepository.findAll();
		else 
			throw new RouteException("Test Exception ....");
	
	} 

	@ExceptionHandler(RouteException.class)
	public GraphQLError exception(RouteException routeException) {
		return new RouteGraphQLError(routeException.getMessage());
	}
	

}
