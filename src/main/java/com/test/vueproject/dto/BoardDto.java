package com.test.vueproject.dto;

import com.test.vueproject.domain.Board.Board;
import lombok.*;

import javax.persistence.Column;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {

    private Long id;
    private String title;
    private String description;
    private boolean published;

    public BoardDto(Board entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        published = entity.isPublished();
    }

    public Board toEntity() {
        return  Board.builder()
                .title(title)
                .description(description)
                .published(published)
                .build();
    }
}
