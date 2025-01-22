package com.example.testcontainer_practice.repository;

import com.example.testcontainer_practice.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

}
