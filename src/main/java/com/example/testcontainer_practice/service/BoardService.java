package com.example.testcontainer_practice.service;

import com.example.testcontainer_practice.connector.out.BoardOutConnector;
import com.example.testcontainer_practice.domain.dto.BoardDto;
import com.example.testcontainer_practice.entity.Board;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardOutConnector boardOutConnector;

    public List<BoardDto.Response> boardList() {
        return boardOutConnector.boardList()
                .stream()
                .map(this::toDtoResponse)
                .collect(Collectors.toList());
    };

    public BoardDto.Response boardDetail(Long id) {
        Optional<Board> board = boardOutConnector.findById(id);

        BoardDto.Response response = BoardDto.Response
                .builder()
                .board(board.get())
                .build();

        return response;
    };

    public BoardDto.Response save(BoardDto.Request request) {

        Board board = Board
                .builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .contents(request.getContents())
                .createdBy(request.getAuthor())
                .updatedBy(request.getAuthor())
                .createdTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();

        return toDtoResponse(boardOutConnector.save(board));
    };

    public BoardDto.Response update(Long id,BoardDto.Request request) {
        Board board = boardOutConnector.findById(id).orElseThrow();
        board.update(request);
        return toDtoResponse(boardOutConnector.save(board));
    };

    public void delete(Long id) {
        boardOutConnector.delete(id);
    };

    private BoardDto.Response toDtoResponse(Board board) {
        return BoardDto.Response
                .builder()
                .board(board)
                .build();
    }
}
