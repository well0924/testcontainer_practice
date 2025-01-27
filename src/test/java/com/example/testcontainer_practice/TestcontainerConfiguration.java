package com.example.testcontainer_practice;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MariaDBContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainerConfiguration {

    @Bean
    public MariaDBContainer<?> mariaDbContainer() {
        MariaDBContainer<?> container = new MariaDBContainer<>("mariadb:latest")
                .withDatabaseName("testdb")
                .withUsername("test")
                .withPassword("test");
        return container;
    }
}
