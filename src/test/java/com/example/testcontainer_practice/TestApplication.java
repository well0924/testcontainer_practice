package com.example.testcontainer_practice;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;


public class TestApplication {

    @Bean
    @Primary
    public MariaDBContainer<?> mariaDbContainer() {
        MariaDBContainer<?> container = new MariaDBContainer<>("mariadb:latest")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
        container.start();
        return container;
    }

    @Bean
    @Primary
    public DataSource dataSource(MariaDBContainer<?> mariaDbContainer) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(mariaDbContainer.getJdbcUrl());
        dataSource.setUsername(mariaDbContainer.getUsername());
        dataSource.setPassword(mariaDbContainer.getPassword());
        dataSource.setDriverClassName(mariaDbContainer.getDriverClassName());
        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.from(TestContainerPracticeApplication::main)
                .with(TestApplication.class)
                .run(args);
    }

}
