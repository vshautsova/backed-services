package com.epam.vshautsova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Class to run spring boot application.
 */
@SpringBootApplication
public class SpringBootFoundationApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootFoundationApplication.class, args);
	}

	@Bean
	public WebClient webClient()
	{
		return WebClient.create();
	}
}
