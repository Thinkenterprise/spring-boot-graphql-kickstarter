package com.thinkenterprise.domain.route.graphql.resolver.query.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thinkenterprise.domain.route.graphql.model.GraphQLRoute;
import com.thinkenterprise.domain.route.jpa.repository.RouteRepository;

import ma.glasnost.orika.MapperFacade;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

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
