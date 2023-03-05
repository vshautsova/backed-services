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

- profiles-configuration

Separate Data Source Configurations Using Profiles:

There should be 2 different Data Sources - one for QA and one for DEV.
Introduce 2 data sources(using @Component and @Profile("QA")/ @Component and @Profile("DEV"))
Implement test(using @ActiveProfile("DEV")) which tests your application by requesting data from DEV Data Source.


## Check implementation
1. Import as maven project
2. In each module execute mvn clean install to verify tests are passed correctly.
