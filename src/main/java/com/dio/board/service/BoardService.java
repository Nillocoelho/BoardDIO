
package com.dio.board.service;

import com.dio.board.model.*;
import com.dio.board.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class BoardService {
    private final BoardRepository boardRepo;
    private final LaneRepository laneRepo;

    public BoardService(BoardRepository boardRepo, LaneRepository laneRepo){
        this.boardRepo = boardRepo; this.laneRepo = laneRepo;
    }

    @Transactional
    public Board createDefaultBoard(String name){
        Board board = new Board(name);
        board = boardRepo.save(board);
        Lane todo = new Lane(board, "To Do", 0);
        Lane doing = new Lane(board, "Doing", 1);
        Lane done = new Lane(board, "Done", 2);
        laneRepo.saveAll(Arrays.asList(todo, doing, done));
        return boardRepo.findById(board.getId()).orElseThrow();
    }

    public List<Board> listBoards(){
        return boardRepo.findAll();
    }

    public Optional<Board> get(Long id){
        return boardRepo.findById(id);
    }
}
