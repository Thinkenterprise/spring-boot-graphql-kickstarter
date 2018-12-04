package com.thinkenterprise.resolver.subscription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.thinkenterprise.domain.route.Route;
import com.thinkenterprise.publisher.RouteUpdatePublisher;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RootSubscriptionResolver implements GraphQLSubscriptionResolver {

        RouteUpdatePublisher routeUpdatePublisher;

        @Autowired
        public RootSubscriptionResolver(RouteUpdatePublisher routeUpdatePublisher) {
                this.routeUpdatePublisher=routeUpdatePublisher;
        }

        public Publisher<Route> registerRouteCreated() {
                return routeUpdatePublisher.getPublisher();
        }

}