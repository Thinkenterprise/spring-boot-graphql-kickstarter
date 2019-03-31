package com.thinkenterprise.domain.route.graphql.publisher;

import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.route.jpa.model.Route;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Component
public class RouteCreatePublisher {

    private final Flowable<Route> publisher;
    private ObservableEmitter<Route> observableEmitter;

    public RouteCreatePublisher() {
        Observable<Route> stockPriceUpdateObservable = Observable.create(emitter -> {
            observableEmitter=emitter;
        });

        ConnectableObservable<Route> connectableObservable = stockPriceUpdateObservable.share().publish();
        connectableObservable.connect();

        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    public void emit(Route route) {
        observableEmitter.onNext(route);
    }

    public Flowable<Route> getPublisher() {
        return publisher;
    }

}
