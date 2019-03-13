package com.thinkenterprise.domain.route.mapper;

import com.thinkenterprise.domain.route.graphql.model.GraphQLFlight;
import com.thinkenterprise.domain.route.graphql.model.GraphQLRoute;
import com.thinkenterprise.domain.route.jpa.model.Flight;
import com.thinkenterprise.domain.route.jpa.model.Route;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class JPA2GraphQLFlightMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
	
		factory.classMap(Flight.class, GraphQLFlight.class).mapNulls(true).byDefault().register();
		
	}
	

}
