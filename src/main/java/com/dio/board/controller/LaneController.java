
package com.dio.board.controller;

import com.dio.board.model.Lane;
import com.dio.board.repository.LaneRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lanes")
@CrossOrigin
public class LaneController {
    private final LaneRepository laneRepo;

    public LaneController(LaneRepository laneRepo){
        this.laneRepo = laneRepo;
    }

    @GetMapping
    public List<Lane> list(){ return laneRepo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Lane> get(@PathVariable Long id){
        return laneRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
