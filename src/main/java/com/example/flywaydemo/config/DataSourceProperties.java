package com.example.flywaydemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.lang.NonNull;

import javax.sql.DataSource;
import java.util.Properties;

@Getter
@Setter
public class DataSourceProperties {
    private String url;
    private String schema;
    private String username;
    private String password;
    private Integer minimumIdle = 2;
    private Integer maximumPoolSize = 5;
    private String poolName = "spring";
    private Integer idleTimeout = 30_000;
    private Integer connectionTimeout = 30_000;

    public DataSource getDataSource(){
        return DataSourceBuilder.create()
                                .url(getUrl())
                                .username(getUsername())
                                .password(getPassword())
                                .build();
    }

    public void generateProperties(@NonNull Properties jpaProperties){
        jpaProperties.put("hibernate.hikari.jdbcUrl", getUrl());
        jpaProperties.put("hibernate.hikari.username", getUsername());
        jpaProperties.put("hibernate.hikari.password", getPassword());
        jpaProperties.put("hibernate.hikari.minimumIdle", getMinimumIdle());
        jpaProperties.put("hibernate.hikari.maximumPoolSize", getMaximumPoolSize());
        jpaProperties.put("hibernate.hikari.poolName", getPoolName());
        jpaProperties.put("hibernate.hikari.idleTimeout", getIdleTimeout());
        jpaProperties.put("hibernate.hikari.connectionTimeout", getConnectionTimeout());
    }
}
