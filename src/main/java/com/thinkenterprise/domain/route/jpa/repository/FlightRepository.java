package com.thinkenterprise.domain.route.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thinkenterprise.domain.route.jpa.model.Flight;
import com.thinkenterprise.domain.route.jpa.model.Route;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public interface FlightRepository extends CrudRepository<Flight, Long> {


	@Query( "select f from Flight f where id in :keys" )
	List<Flight> findAllById(@Param("keys") List<Long> keys);

	@Query( "select f from Flight f where f.route = :route")
	List<Flight> findByRoute(@Param("route") Route route);
	
	@Query( "select f.id from Flight f where f.route = :route")
	List<Long> findIdsByRoute(@Param("route") Route route);
	
	
	
}
