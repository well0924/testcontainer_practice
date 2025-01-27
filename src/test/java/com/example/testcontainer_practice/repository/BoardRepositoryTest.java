package com.example.testcontainer_practice.repository;

import com.example.testcontainer_practice.TestcontainerConfig;
import com.example.testcontainer_practice.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestcontainerConfig
public class BoardRepositoryTest  {

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
