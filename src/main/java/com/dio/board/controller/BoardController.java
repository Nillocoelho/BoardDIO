
package com.dio.board.controller;

import com.dio.board.model.Board;
import com.dio.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping
    public List<Board> list(){ return boardService.listBoards(); }

    @PostMapping("/default")
    public ResponseEntity<Board> createDefault(@RequestParam String name){
        Board created = boardService.createDefaultBoard(name);
        return ResponseEntity.created(URI.create("/api/boards/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> get(@PathVariable Long id){
        return boardService.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
