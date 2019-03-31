package com.thinkenterprise.domain.route.graphql.model;

import java.util.List;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class GraphQLRoute  {

	private Long id;
	private String flightNumber;
	private String departure;
	private String destination;
	private Boolean disabled;

	
	private List<GraphQLFlight> flights;

	public GraphQLRoute() {
		super();
	}

	public GraphQLRoute(String flightNumber) {
		super();
		this.flightNumber = flightNumber;
	}

	public GraphQLRoute(String flightNumber, String departure, String destination, Boolean disabled) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.departure = departure;
		this.disabled = disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String number) {
		this.flightNumber = number;
	}

	public List<GraphQLFlight> getFlights() {
		return flights;
	}

	public void setFlights(List<GraphQLFlight> flights) {
		this.flights = flights;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
