package com.thinkenterprise.publisher;

import com.thinkenterprise.domain.route.Route;

import org.springframework.stereotype.Component;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;

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
