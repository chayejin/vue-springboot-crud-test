package com.test.vueproject.dto.Board;

import com.test.vueproject.domain.Board.Board;
import com.test.vueproject.domain.User.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private String content;
    private User user;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}
