package com.epam.vshautsova;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootFoundationApplicationTest
{
	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testCustomEndpoint()
	{
		webTestClient.get().uri("/actuator/custom")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("Custom endpoint response.");
	}
}
