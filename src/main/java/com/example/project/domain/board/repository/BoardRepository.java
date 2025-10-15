package com.example.project.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.domain.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
