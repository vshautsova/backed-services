package com.epam.vshautsova;

import com.epam.vshautsova.util.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Test of SpringBootFoundationApplication.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootFoundationApplicationTest
{
	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testCustomEndpoint()
	{
		webTestClient.get().uri(Constants.CUSTOM_ENDPOINT_PATH)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo(Constants.CUSTOM_ENDPOINT_RESPONSE_MSG);
	}
}
