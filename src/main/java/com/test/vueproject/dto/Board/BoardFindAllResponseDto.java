package com.test.vueproject.dto.Board;

import com.test.vueproject.domain.Board.Board;
import com.test.vueproject.domain.User.User;
import lombok.Getter;

@Getter
public class BoardFindAllResponseDto {

    private Long id;
    private String title;
    private String content;
    private Board board;
    private User user;

    public BoardFindAllResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.user = board.getUser();

    }
}
