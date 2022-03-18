package com.test.vueproject.service;

import com.test.vueproject.domain.Board.Board;
import com.test.vueproject.domain.Board.BoardRepository;
import com.test.vueproject.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoardService {

    private BoardRepository boardRepository;

    @Transactional
    public BoardDto boardCreateRequest(BoardDto dto) {
        return new BoardDto(boardRepository.save(dto.toEntity()));
    }

    @Transactional
    public BoardDto boardFindByIdResponse(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        return new BoardDto(board);
    }

    @Transactional
    public List<BoardDto> boardFindByPublished() {
        List<BoardDto> boards = new ArrayList<BoardDto>();
        boardRepository.findByPublished(true).forEach(board -> boards.add(new BoardDto(board)));
        return boards;
    }

    @Transactional
    @ReadOnlyProperty
    public List<BoardDto> boardFindAllResponse() {
        return boardRepository.findAll().stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @ReadOnlyProperty
    public List<BoardDto> boardFindAllTitleResponse(String title) {
        List<BoardDto> boards = new ArrayList<BoardDto>();
        boardRepository.findByTitleContaining(title).forEach(board -> boards.add(new BoardDto(board)));
        return boards;
    }

    @Transactional
    public BoardDto boardUpdateRequest(BoardDto dto){
        return new BoardDto(boardRepository.save(dto.toEntity()));
    }

    @Transactional
    public void boardDeleteRequest(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void boardDeleteAllRequest() {
        boardRepository.deleteAll();
    }
}
