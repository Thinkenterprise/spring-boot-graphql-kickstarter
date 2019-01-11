package com.thinkenterprise.security;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class GraphQLSecurityConfiguration {

/*
    @Override
     protected void configure(HttpSecurity http) throws Exception {
        //http.httpBasic().and().authorizeRequests().antMatchers("/graphql").permitAll();
        http.authorizeRequests() 
        .antMatchers("/*").permitAll();    
        
    }
*/
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
   	    auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}password")
            .roles("ADMIN");
    }
    */
}