package com.example.testcontainer_practice.controller;

import com.example.testcontainer_practice.connector.in.BoardInConnector;
import com.example.testcontainer_practice.domain.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardInConnector boardInConnector;

    @GetMapping("/")
    public ResponseEntity<List<BoardDto.Response>> boardList() {
        List<BoardDto.Response>list = boardInConnector.boardList();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDto.Response> getBoard(@PathVariable("id")Long id) {
        BoardDto.Response boardDetail = boardInConnector.boardDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardDetail);
    }

    @PostMapping("/")
    public ResponseEntity<BoardDto.Response> createBoard(@RequestBody BoardDto.Request request) {
        BoardDto.Response createResponse = boardInConnector.save(request);
        return ResponseEntity.status(HttpStatus.OK).body(createResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDto.Response> updateBoard(@PathVariable("id") Long id,@RequestBody BoardDto.Request request) {
        BoardDto.Response updateResponse = boardInConnector.update(id,request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("id")Long id) {
        boardInConnector.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
