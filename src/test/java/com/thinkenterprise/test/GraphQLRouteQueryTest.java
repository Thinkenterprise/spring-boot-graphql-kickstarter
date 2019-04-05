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
public class GraphQLRouteQueryTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void routeQueryroutes() throws IOException { 
        GraphQLResponse response  = graphQLTestTemplate.postForResource("routes.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals("101", response.get("$.data.routes[0].id"));
    }
    
     
      
}