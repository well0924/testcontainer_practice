package com.example.testcontainer_practice.connector.interfaces;

import com.example.testcontainer_practice.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardOutInterfaces {

    //글 목록
    List<Board> boardList();
    //글 조회
    Optional<Board> findById(Long id);
    //글 작성
    Board save(Board board);
    //글 삭제
    void delete(Long id);
}
