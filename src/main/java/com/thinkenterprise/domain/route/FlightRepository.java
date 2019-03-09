package com.thinkenterprise.domain.route;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends CrudRepository<Flight, Long> {


	@Query( "select f from Flight f where id in :keys" )
	List<Flight> findAllById(@Param("keys") List<Long> keys);

	@Query( "select f from Flight f where f.route = route")
	List<Flight> findbyRoute(@Param("route") Long route);
	
	@Query( "select f.id from Flight f where f.route = route")
	List<Long> findIdsbyRoute(@Param("route") Long route);
	
	
	
}
