package com.epam.vshautsova.endpoint;

import com.epam.vshautsova.util.Constants;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * Custom spring boot actuator endpoint.
 */
@Component
@Endpoint(id = "custom")
public class CustomEndpoint
{
	@ReadOperation
	public String getCustomInfo()
	{
		return Constants.CUSTOM_ENDPOINT_RESPONSE_MSG;
	}
}
