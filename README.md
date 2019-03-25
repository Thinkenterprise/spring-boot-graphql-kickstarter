# spring-boot-graphql
Sample application for the **Java Magazin 5.19** article 


## Features 

1. CRUD over GraphQL API 
2. Test your GraphQL API
3. Create GraphQL Error over Exception Handling
4. Model Mapping over Orika  
5. Subscribe on Events over your GraphQL API 
6. Secure your GraphQL API over Basic Authentication     
7. Secure your GraphQL API over OAuth 2/JWT 
8. Performance Tuning over Batch Loading & Caching  
9. GraphQL Context 

## GrapQL Queries 
All supported GraphQL Queries are stored under `src/test/resources`

## First Run    

`git clone https://github.com/Thinkenterprise/spring-boot-graphql.git`

`mvn clean install`

`mvn spring-boot:run`

`curl -X POST 'http://localhost:4000/graphql' -H 'Content-Type: application/json' -d '{"query":"{routes{id}}"}'`

It is easier to test the application via Playground or Postman. 


## Enable Basic Authentication Feature 
To test the security *Basic Authentication* feature you have to set profile `basicSecurity` there and delete the profile `noSecurity`. 

curl -u user:password -X POST 'http://localhost:4000/graphql' -H 'Content-Type: application/json' -d '{"query":"{routes{id}}"}'

## Enable OAuth2/JWT Feature 

To test the security *OAuth2/JWT* feature you have to set profile `OAuth2Security` there and delete the profile `noSecurity`. 

curl -X POST 'http://localhost:4000/graphql' -H 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJyZWFkIl0sImV4cCI6MjE0NDA4NjQ0MCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sInVzZXJfbmFtZSI6InRvbSIsImp0aSI6ImM4N2Q5NTNjLTZlZDAtNGRlMy1hZTJlLTMwZTcwOTYyNjExNyIsImNsaWVudF9pZCI6ImZvbyJ9.vOx3WIajVeaPelFuYttvSjvOSXw5POwzQiZPxQmH6eSQTVR_YCHHzd0vh2a00g3spZ0-S7fZfkiFuNF-QJogGS-GER-B8p4c6mMrazN0x-wytMVM6xZrQbner0Uqu_uuK1vQs-gm2-2BFpydQtq-ZYicss21RSJTLK7fuH5DzHQ' -H 'Content-Type: application/json' -d '{"query":"{routes{id}}"}'


## Enable Performance Feature
The profile `context` activates the context that provides the data loaders in the resolvers. You can add the profile to the current profile setting. 

Enable the Data Loader in Class `RouteQueryResolver`


``` java 
public CompletableFuture<List<Flight>> flights(Route route, DataFetchingEnvironment dataFetchingEnvironment) {  
   DataLoader<Long,Flight> dataLoader = dataFetchingEnvironment.getDataLoader("flight");
    return dataLoader.loadMany(KeyUtils.getKeys(route.getId()));
}
``` 

and disbale the existing field resolver  

``` java
public List<Flight> flights(Route route) {
    	return route.getFlights();
}
```
## Enable the Mapper Feature 
The mapping is switched on via the profile `mapping`. You can add the profile to the current profile setting. Attention with this profile we read another GraphQL schema and only queries are available. 