
package com.thinkenterprise.domain.route.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thinkenterprise.domain.route.jpa.model.Route;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public interface RouteRepository extends CrudRepository<Route, Long>{
	
	@Query("select r from Route r")
	List<Route> findAll();
	
	@Query( "select r from Route r where r.id = :route")
	List<Route> findByFlight(@Param("route") Long route);
	
}