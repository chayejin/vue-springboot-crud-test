package com.test.vueproject;

import com.test.vueproject.domain.Board.Board;
import com.test.vueproject.domain.Board.BoardRepository;
import com.test.vueproject.domain.User.User;
import com.test.vueproject.domain.User.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;



@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void ImplicitInnerJoinUserPost() {
        //given
        User user = userRepository.save(User.builder()
                .name("yejin")
                .password("test")
                .build());

        boardRepository.save(Board.builder()
                .title("hi")
                .content("hihihi")
                .user(user)
                .build());

        //when
        /** select u.boards from User u*/
        List<Board> boards = userRepository.ImplicitInnerJoinUserBoard();


        System.out.println(boards.size()==1);


    }

}
