package com.thinkenterprise.domain.route.graphql.error;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class RouteGraphQLError implements GraphQLError {
   
    private static final long serialVersionUID = -6780513777815584903L;

    private String message;

    public RouteGraphQLError() {
        super();
    }

    public RouteGraphQLError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

	@Override
	public ErrorType getErrorType() {
		return ErrorType.ExecutionAborted;
	} 
    
}