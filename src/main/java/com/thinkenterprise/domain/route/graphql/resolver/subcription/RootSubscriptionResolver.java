package com.thinkenterprise.domain.route.graphql.resolver.subcription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.thinkenterprise.domain.route.graphql.publisher.RouteCreatePublisher;
import com.thinkenterprise.domain.route.jpa.model.Route;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!mapper")
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