package com.thinkenterprise.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLContextBuilder;

public class RouteGraphQLContextBuilder implements GraphQLContextBuilder {

	
		private String token;
	
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
	        return new RouteGraphQLContext(token, httpServletRequest, httpServletResponse);
	    }

	    @Override
	    public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
	        return new RouteGraphQLContext(token, session, handshakeRequest);
	    }

	    @Override
	    public GraphQLContext build() {
	        return new RouteGraphQLContext(token);
	    }

}
