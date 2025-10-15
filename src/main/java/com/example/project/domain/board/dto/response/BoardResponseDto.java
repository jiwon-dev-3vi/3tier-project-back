package com.example.project.domain.board.dto.response;

import com.example.project.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String createdAt;
    private final String updatedAt;

    @Builder
    private BoardResponseDto(Long id, String title, String content, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static BoardResponseDto of(Board board, String createdAt, String updatedAt) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
