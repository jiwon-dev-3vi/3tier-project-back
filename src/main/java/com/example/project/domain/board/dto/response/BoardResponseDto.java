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
    private final String modifiedAt;

    @Builder
    private BoardResponseDto(Long id, String title, String content, String createdAt, String modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static BoardResponseDto of(Board board, String createdAt, String modifiedAt) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }
}
