package com.example.project.domain.board.controller;

import com.example.project.domain.board.dto.request.CreateBoardRequestDto;
import com.example.project.domain.board.dto.response.BoardResponseDto;
import com.example.project.domain.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    /**
     * 게시글 생성 API
     * 
     * @body CreateBoardRequestDto [title, content]
     * @return BoardResponseDto [id, title, content, createAt, modifiedAt]
     */
    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(
        @Valid @RequestBody CreateBoardRequestDto createBoardRequestDto
    ) {
        log.info("Request to create Board");

        return ResponseEntity.status(201)
                .body(boardService.createBoard(createBoardRequestDto));
    }

    /**
     * 게시글 전체 조회 API
     * @param page (페이지 번호)
     * @param size (페이지 내 요소 수)
     * @return Page<BoardResponseDto> [id, title, content, createAt, modifiedAt]
     */
    @GetMapping("/all")
    public ResponseEntity<Page<BoardResponseDto>> getBoardsOrderByCreatedAt(
        @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        log.info("Request to get boards");
        return ResponseEntity.ok(boardService.getBoardsOrderByCreatedAt(pageable));
    }
}
