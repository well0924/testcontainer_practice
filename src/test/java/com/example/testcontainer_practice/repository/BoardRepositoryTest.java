package com.example.testcontainer_practice.repository;

import com.example.testcontainer_practice.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Testcontainers
public class BoardRepositoryTest {

    @Container
    @ServiceConnection
    static MariaDBContainer<?> container = new MariaDBContainer<>("mariadb:latest")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void boardCreatTest() {
        Board board = Board
                .builder()
                .title("test title")
                .contents("test contents")
                .author("test author")
                .build();
        boardRepository.save(board);

        assertThat(board).isNotNull();
    }
}
