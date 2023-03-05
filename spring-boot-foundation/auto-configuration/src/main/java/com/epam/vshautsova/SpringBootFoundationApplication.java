package com.epam.vshautsova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.epam.vshautsova.configuration")
public class SpringBootFoundationApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootFoundationApplication.class, args);
	}

}
