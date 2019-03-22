package com.thinkenterprise.domain.route.graphql.performance;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;

import com.thinkenterprise.domain.route.jpa.model.Flight;

public class FlightDataLoader extends DataLoader<Long, Flight> {

	public FlightDataLoader(BatchLoader<Long, Flight> batchLoadFunction) {
		super(batchLoadFunction);
	}

}
