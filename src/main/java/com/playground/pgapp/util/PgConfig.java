package com.playground.pgapp.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PgConfig {
    @Bean("playgroundDataSource")
    public DataSource pgDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/playground");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        return  dataSource;
    }
}
