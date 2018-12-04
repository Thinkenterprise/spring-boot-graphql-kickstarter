package com.thinkenterprise.resolver.subscription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.publisher.RouteCreatePublisher;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RootSubscriptionResolver implements GraphQLSubscriptionResolver {

        RouteCreatePublisher routeCreatePublisher;

        @Autowired
        public RootSubscriptionResolver(RouteCreatePublisher routeCreatePublisher) {
                this.routeCreatePublisher=routeCreatePublisher;
        }

        public Publisher<Route> registerRouteCreated() {
                return routeCreatePublisher.getPublisher();
        }

}