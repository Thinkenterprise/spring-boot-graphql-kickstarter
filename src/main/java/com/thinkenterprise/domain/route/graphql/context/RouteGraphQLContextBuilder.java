package com.thinkenterprise.domain.route.graphql.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import com.thinkenterprise.domain.route.graphql.performance.FlightBatchLoader;
import com.thinkenterprise.domain.route.graphql.performance.FlightDataLoader;
import com.thinkenterprise.domain.route.jpa.repository.FlightRepository;

import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLContextBuilder;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class RouteGraphQLContextBuilder implements GraphQLContextBuilder {
	
		private String token;
		
		@Autowired
		private FlightRepository flightRepository;
	
		public RouteGraphQLContextBuilder(String token) {
			super();
			this.token = token;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		@Override
	    public GraphQLContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
			RouteGraphQLContext routeGraphQLContext = new RouteGraphQLContext(token, httpServletRequest, httpServletResponse);
			routeGraphQLContext.setDataLoaderRegistry(buildDataLoaderRegistry());
			return routeGraphQLContext; 
	    }

	    @Override
	    public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
	    	RouteGraphQLContext routeGraphQLContext = new RouteGraphQLContext(token, session, handshakeRequest);
	    	routeGraphQLContext.setDataLoaderRegistry(buildDataLoaderRegistry());
	        return  routeGraphQLContext;
	    }

	    @Override
	    public GraphQLContext build() {
	    	RouteGraphQLContext routeGraphQLContext = new RouteGraphQLContext(token);
	    	routeGraphQLContext.setDataLoaderRegistry(buildDataLoaderRegistry());
	        return routeGraphQLContext; 
	    }
	    
	    private DataLoaderRegistry buildDataLoaderRegistry() {	
	    	DataLoaderRegistry dataLoaderRegistry = new DataLoaderRegistry();
	    	dataLoaderRegistry.register("flight", new FlightDataLoader(new FlightBatchLoader(flightRepository)));
	    	return dataLoaderRegistry;
	    	 	
	    }
}
