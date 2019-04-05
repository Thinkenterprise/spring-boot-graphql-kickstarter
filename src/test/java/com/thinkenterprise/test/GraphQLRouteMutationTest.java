package com.thinkenterprise.test;

import static graphql.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode=ClassMode.BEFORE_EACH_TEST_METHOD)
public class GraphQLRouteMutationTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

        
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
        assertEquals("LH7902", response.get("$.data.updateRoute.flightNumber"));
    }
    
    @Test
    public void routeQueryDeleteRoute() throws IOException {       
        GraphQLResponse response  = graphQLTestTemplate.postForResource("deleteRoute.graphql");
        assertEquals(true, response.get("$.data.deleteRoute", Boolean.class));
    }
       
}