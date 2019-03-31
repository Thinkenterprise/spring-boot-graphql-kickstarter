package com.thinkenterprise.domain.route.graphql.performance;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;

import com.thinkenterprise.domain.route.jpa.model.Flight;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class FlightDataLoader extends DataLoader<Long, Flight> {

	public FlightDataLoader(BatchLoader<Long, Flight> batchLoadFunction) {
		super(batchLoadFunction);
	}

}
