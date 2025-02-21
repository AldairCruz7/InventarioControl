package com.inventariocontrol.config;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SchemaInitializer {

    private final JdbcTemplate jdbcTemplate;

    public SchemaInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void createSchemas() {
        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS usuario;");
        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS inventario;");
    }
}
