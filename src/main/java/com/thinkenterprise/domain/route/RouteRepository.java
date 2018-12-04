
package com.thinkenterprise.domain.route;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, Long>{
	
	@Query("select r from Route r")
	List<Route> findAll();
	
}