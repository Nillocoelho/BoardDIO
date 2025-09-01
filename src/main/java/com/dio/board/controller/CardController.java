
package com.dio.board.controller;

import com.dio.board.dto.CreateCardRequest;
import com.dio.board.dto.MoveCardRequest;
import com.dio.board.model.Card;
import com.dio.board.model.Lane;
import com.dio.board.repository.LaneRepository;
import com.dio.board.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin
public class CardController {
    private final CardService cardService;
    private final LaneRepository laneRepo;

    public CardController(CardService cardService, LaneRepository laneRepo){
        this.cardService = cardService;
        this.laneRepo = laneRepo;
    }

    @GetMapping
    public List<Card> all(){ return cardService.findAll(); }

    @PostMapping
    public ResponseEntity<Card> create(@RequestBody CreateCardRequest req){
        Lane lane = laneRepo.findById(req.laneId).orElseThrow();
        Card card = new Card(lane, req.title, 0);
        card.setDescription(req.description);
        card.setDueDate(req.dueDate);
        card.setPriority(req.priority);
        Card saved = cardService.create(card);
        return ResponseEntity.created(URI.create("/api/cards/" + saved.getId())).body(saved);
    }

    @GetMapping("/{id}")
    public Card get(@PathVariable Long id){ return cardService.get(id); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/move")
    public Card move(@RequestBody MoveCardRequest req){
        return cardService.move(req.cardId, req.targetLaneId, req.targetOrderIndex);
    }
}
