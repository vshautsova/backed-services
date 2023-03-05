package com.epam.vshautsova.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Data Source configuration for dev profile.
 */
@Component
@Profile("dev")
public class DevDataSourceConfiguration implements DataSourceConfiguration
{
	@Value("${spring.datasource.dev.url}")
	private String url;

	@Value("${spring.datasource.dev.username}")
	private String username;

	@Bean
	@Override
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.url(url)
				.username(username)
				.build();
	}
}
