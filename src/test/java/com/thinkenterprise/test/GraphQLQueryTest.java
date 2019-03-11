package com.thinkenterprise.test;

import static graphql.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class GraphQLQueryTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;
    
    @Autowired
    private RestTemplateFactory restTemplateFactory;
    
    @Test
    public void routeQueryroutes() throws IOException {
       
        GraphQLResponse response  = graphQLTestTemplate.postForResource("routes.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
        //assertNotNull(response.get("$.data.routes.id"));
    }
       
    @Test
    public void routeQueryCreateRoute() throws IOException {       
        GraphQLResponse response  = graphQLTestTemplate.postForResource("createRoute.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals("RO311", response.get("$.data.createRoute.flightNumber"));
        assertEquals("1", response.get("$.data.createRoute.id"));
    }
    
    @Test
    public void routeQueryUpdateRoute() throws IOException {       
        GraphQLResponse response  = graphQLTestTemplate.postForResource("updateRoute.graphql");
        response  = graphQLTestTemplate.postForResource("updateRoute.graphql");
        assertEquals("LH7902", response.get("$.data.updateRoute.flightNumber"));
    }
    
    @Test
    public void routeQueryDeleteRoute() throws IOException {       
        GraphQLResponse response  = graphQLTestTemplate.postForResource("deleteRoute.graphql");
        assertEquals(true, response.get("$.data.deleteRoute", Boolean.class));
    }
    
  
    
}