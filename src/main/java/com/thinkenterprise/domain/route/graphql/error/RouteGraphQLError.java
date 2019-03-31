package com.thinkenterprise.domain.route.graphql.error;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

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