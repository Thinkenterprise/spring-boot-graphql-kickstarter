package com.thinkenterprise.cache;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;

import com.thinkenterprise.domain.route.Flight;

public class FlightDataLoader extends DataLoader<Long, Flight> {

	public FlightDataLoader(BatchLoader<Long, Flight> batchLoadFunction) {
		super(batchLoadFunction);
	}

}
