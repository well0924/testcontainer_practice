package com.example.testcontainer_practice.connector.out;

import com.example.testcontainer_practice.connector.interfaces.BoardOutInterfaces;
import com.example.testcontainer_practice.entity.Board;
import com.example.testcontainer_practice.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
@AllArgsConstructor
public class BoardOutConnector implements BoardOutInterfaces {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
