package com.thinkenterprise.domain.route;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class RouteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RouteException(String message) {
        super(message);
    }
    
}