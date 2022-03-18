package com.test.vueproject;

import com.test.vueproject.domain.Board.Board;
import com.test.vueproject.dto.BoardDto;
import com.test.vueproject.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardApiTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void boardCreateRequestTest() {
        // given
        Board input = Board.builder()
                .title("Wongok")
                .description("Park")
                .published(false)
                .build();


        // when
        boardService.boardCreateRequest(new BoardDto(input));

        List<BoardDto> test = boardService.boardFindAllResponse();

        // then
        System.out.println("");
    }

}
