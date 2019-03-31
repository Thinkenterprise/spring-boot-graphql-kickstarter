package com.thinkenterprise.domain.route.mapper;

import com.thinkenterprise.domain.route.graphql.model.GraphQLRoute;
import com.thinkenterprise.domain.route.jpa.model.Route;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class JPA2GraphQLRouteMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
	
		factory.classMap(Route.class, GraphQLRoute.class).mapNulls(true).byDefault().register();
		
	}
	

}
