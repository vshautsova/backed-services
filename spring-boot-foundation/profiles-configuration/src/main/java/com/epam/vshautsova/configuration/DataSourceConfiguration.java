package com.epam.vshautsova.configuration;

import javax.sql.DataSource;

/**
 * Custom Data Source Configuration.
 */
public interface DataSourceConfiguration
{
    /**
     * Data source provisioning.
     *
     * @return DataSource
     */
    public DataSource dataSource();
}
