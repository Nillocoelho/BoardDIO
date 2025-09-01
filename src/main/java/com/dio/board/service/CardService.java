
package com.dio.board.service;

import com.dio.board.model.*;
import com.dio.board.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepo;
    private final LaneRepository laneRepo;

    public CardService(CardRepository cardRepo, LaneRepository laneRepo){
        this.cardRepo = cardRepo; this.laneRepo = laneRepo;
    }

    public Card create(Card card){
        return cardRepo.save(card);
    }

    public List<Card> findAll(){ return cardRepo.findAll(); }

    public Card get(Long id){ return cardRepo.findById(id).orElseThrow(); }

    public void delete(Long id){ cardRepo.deleteById(id); }

    @Transactional
    public Card move(Long cardId, Long targetLaneId, Integer targetOrder){
        Card card = cardRepo.findById(cardId).orElseThrow();
        Lane target = laneRepo.findById(targetLaneId).orElseThrow();
        card.setLane(target);
        card.setOrderIndex(targetOrder == null ? 0 : targetOrder);
        return card;
    }
}
