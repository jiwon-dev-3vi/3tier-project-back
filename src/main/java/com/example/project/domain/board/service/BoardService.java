package com.example.project.domain.board.service;

import com.example.project.common.utils.TimeUtils;
import com.example.project.domain.board.dto.request.CreateBoardRequestDto;
import com.example.project.domain.board.dto.response.BoardResponseDto;
import com.example.project.domain.board.entity.Board;
import com.example.project.domain.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public BoardResponseDto createBoard(CreateBoardRequestDto createBoardRequestDto) {
        Board board = Board.of(createBoardRequestDto.getTitle(), createBoardRequestDto.getContent());
        boardRepository.save(board);

        return BoardResponseDto.of(
                board,
                TimeUtils.formatToDateTimeWithMinutes(board.getCreatedAt()),
                TimeUtils.formatToDateTimeWithMinutes(board.getModifieddAt())
        );
    }

    @Transactional(readOnly = true)
    public Page<BoardResponseDto> getBoardsOrderByCreatedAt(Pageable pageable) {

        Page<Board> boards = boardRepository.findAll(pageable);

        return boards.map(board -> 
            BoardResponseDto.of(
                board,
                TimeUtils.formatToDateTimeWithMinutes(board.getCreatedAt()),
                TimeUtils.formatToDateTimeWithMinutes(board.getModifieddAt())
            )
        );
    }
}
