package com.thinkenterprise.domain.route.graphql.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

import graphql.servlet.GraphQLContext;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class RouteGraphQLContext extends GraphQLContext{

	
	private String token;

	public RouteGraphQLContext(String token) {
		super();
		this.token = token;
	}
	
	public RouteGraphQLContext(String token, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		super(httpServletRequest,httpServletResponse);
		this.token = token;
	}
	
	public RouteGraphQLContext(String token, Session session, HandshakeRequest handshakeRequest) {
		super(session,handshakeRequest);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return token;
	}
	
}
