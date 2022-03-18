package com.test.vueproject.controller;

import com.test.vueproject.domain.Board.Board;
import com.test.vueproject.domain.Board.BoardRepository;
import com.test.vueproject.dto.BoardDto;
import com.test.vueproject.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BoardApiController {

    private BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<List<BoardDto>> getAllBoards(@RequestParam(required = false) String title) {
        try {
            List<BoardDto> boards = new ArrayList<BoardDto>();
            if (title == null)
                boards = boardService.boardFindAllResponse();
            else
                boards = boardService.boardFindAllTitleResponse(title);
            if (boards.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(boards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/boards/{id}")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable("id") long id) {
        BoardDto boardData = boardService.boardFindByIdResponse(id);
        if (boardData != null) {
            return new ResponseEntity<BoardDto>(boardData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/boards")
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        try {
            BoardDto board = boardService.boardCreateRequest(boardDto);
            return new ResponseEntity<>(board, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/boards/{id}")
    public ResponseEntity<BoardDto> updateBoard(@PathVariable("id") long id, @RequestBody BoardDto boardDto) {
        BoardDto board = boardService.boardUpdateRequest(boardDto);
        if (board != null) {
            return new ResponseEntity<BoardDto>(board, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/boards/{id}")
    public ResponseEntity<HttpStatus> deleteBoard(@PathVariable("id") long id) {
        try {
            boardService.boardDeleteRequest(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/boards")
    public ResponseEntity<HttpStatus> deleteAllBoards() {
        try {
            boardService.boardDeleteAllRequest();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/boards/published")
    public ResponseEntity<List<BoardDto>> findByPublished() {
        try {
            List<BoardDto> boards = boardService.boardFindByPublished();
            if (boards.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(boards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
