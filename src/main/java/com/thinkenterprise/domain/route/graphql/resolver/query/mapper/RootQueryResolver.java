package com.thinkenterprise.domain.route.graphql.resolver.query.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thinkenterprise.domain.route.RouteException;
import com.thinkenterprise.domain.route.graphql.error.RouteGraphQLError;
import com.thinkenterprise.domain.route.graphql.model.GraphQLRoute;
import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.repository.RouteRepository;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import ma.glasnost.orika.MapperFacade;

@Profile("mapper")
@Component
public class RootQueryResolver implements GraphQLQueryResolver {

	private RouteRepository routeRepository;
	
	@Autowired
	private MapperFacade mapperFacade;
	
	@Autowired
	public RootQueryResolver(RouteRepository routeRepository) {
		this.routeRepository=routeRepository;	
	}
	
	public List<GraphQLRoute> routes() {
		List<GraphQLRoute> response = mapperFacade.mapAsList(routeRepository.findAll(), GraphQLRoute.class);
		return response; 
	} 

}
