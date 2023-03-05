package com.epam.vshautsova.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Data Source configuration for qa profile.
 */
@Component
@Profile("qa")
public class QADataSourceConfiguration implements DataSourceConfiguration
{
	@Value("${spring.datasource.qa.url}")
	private String url;

	@Value("${spring.datasource.qa.username}")
	private String username;

	@Value("${spring.datasource.qa.password}")
	private String password;

	@Bean
	@Override
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.url(url)
				.username(username)
				.password(password)
				.build();
	}
}
