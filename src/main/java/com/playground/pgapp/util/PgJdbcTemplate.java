package com.playground.pgapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PgJdbcTemplate {
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(@Qualifier(value = "playgroundDataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
