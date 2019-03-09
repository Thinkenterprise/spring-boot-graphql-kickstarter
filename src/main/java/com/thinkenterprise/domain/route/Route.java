package com.thinkenterprise.domain.route;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

import com.thinkenterprise.domain.AbstractEntity;

@Entity
public class Route extends AbstractEntity {

	private String flightNumber;
	private String departure;
	private String destination;
	private Boolean disabled;


	@OneToMany(mappedBy = "route", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Flight> flights;

	public Route() {
		super();
	}

	public Route(String flightNumber) {
		super();
		this.flightNumber = flightNumber;
	}

	public Route(String flightNumber, String departure, String destination, Boolean disabled) {
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

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}
