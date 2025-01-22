package com.example.testcontainer_practice.connector.in;

import com.example.testcontainer_practice.connector.interfaces.BoardInInterfaces;
import com.example.testcontainer_practice.domain.dto.BoardDto;
import com.example.testcontainer_practice.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BoardInConnector implements BoardInInterfaces {

    private final BoardService boardService;

    @Override
    public List<BoardDto.Response> boardList() {
        return boardService.boardList();
    }

    @Override
    public BoardDto.Response boardDetail(Long id) {
        return boardService.boardDetail(id);
    }

    @Override
    public BoardDto.Response save(BoardDto.Request request) {
        return boardService.save(request);
    }

    @Override
    public BoardDto.Response update(Long id, BoardDto.Request request) {
        return boardService.update(id,request);
    }

    @Override
    public void delete(Long id) {
        boardService.delete(id);
    }
}
