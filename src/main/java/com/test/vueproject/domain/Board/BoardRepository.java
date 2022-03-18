package com.test.vueproject.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
        List<Board> findByPublished(boolean published);
        List<Board> findByTitleContaining(String title);
}
