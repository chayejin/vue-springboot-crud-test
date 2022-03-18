package com.test.vueproject.dto.User;

import com.test.vueproject.domain.User.User;
import com.test.vueproject.dto.Board.BoardFindAllResponseDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserFindALLResponseDto {

    private Long id;
    private String name;
    private String password;
    private List<BoardFindAllResponseDto> boards;

    public UserFindALLResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.boards = user.getBoards().stream()
                .map(BoardFindAllResponseDto::new)
                .collect(Collectors.toList());

    }

}
