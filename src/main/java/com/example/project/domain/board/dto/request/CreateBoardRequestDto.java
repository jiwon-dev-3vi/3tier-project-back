package com.example.project.domain.board.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateBoardRequestDto {
    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 20, message = "제목은 20자 이내로 입력해주세요.")
    private final String title;

    @Size(max = 500, message = "내용은 500자 이내로 입력해주세요.")
    private final String content;
}
