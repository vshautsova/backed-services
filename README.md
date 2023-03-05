# Spring Boot Foundation

The project consists of modules for each task respectively:
- auto-configuration

Create Basic Spring application which will have Data Source Configuration provided by spring Auto-Configuration:

Introduce a configuration(using @Configuration) which should have a method annotated with @Bean which returns a configured data source instance.
Use https://mvnrepository.com/artifact/com.h2database/h2 as a Data Source.
Add test which tests your application by saving an entity to the data source.

- custom-configuration

Create Custom configuration for data source based on conditional properties:

Introduce a configuration(using @Configuration) which should return a data source if an instance of provided interface doesn't exist(@ConditionalOnMissingBean).
Add test which tests your application by saving an entity to the data source.

- actuator-configuration

Enable actuator by adding https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator dependency. 
Expose Default Spring Actuator by configuring SecurityWebFilterChain bean. 
Add a new custom actuator endpoint(using @Component and @Endpoint(id = ...)) and return a custom response. 
