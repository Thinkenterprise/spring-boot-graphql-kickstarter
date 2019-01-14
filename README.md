# spring-boot-graphql
Showcase Spring Boot GraphQL







## Security 
By Default Security is disabled. 

### Basic Authentification 
Basic Authentification can be enabled by setting profile to `basicAuthentification`

### Console Test 

``` console
curl -X POST -u user:password 'http://localhost:4000/graphql' -H 'Content-Type: application/json' -d '{"query":"{routes{id}}"}'
```

### Auth2 with JWT 
Basic Authentification can be enabled by setting profile to `oauth2` 