package com.example.project.domain.board.entity;


import com.example.project.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = true, length = 500)
    private String content;

    @Builder
    private Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Board of(String title, String content) {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
