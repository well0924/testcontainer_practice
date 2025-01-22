package com.example.testcontainer_practice.connector.interfaces;

import com.example.testcontainer_practice.domain.dto.BoardDto;

import java.util.List;

public interface BoardInInterfaces {

    List<BoardDto.Response> boardList();

    BoardDto.Response boardDetail(Long id);

    BoardDto.Response save(BoardDto.Request request);

    BoardDto.Response update(Long id,BoardDto.Request request);

    void delete(Long id);
}
