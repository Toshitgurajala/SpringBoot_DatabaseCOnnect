package com.example.demo.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresDatasource {
    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikaridatasource()
    {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }
}
