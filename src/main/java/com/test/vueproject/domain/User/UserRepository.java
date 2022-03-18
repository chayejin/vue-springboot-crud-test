package com.test.vueproject.domain.User;

import com.test.vueproject.domain.Board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u.boards " +
            "from User u ")
    List<Board> ImplicitInnerJoinUserBoard();
}
