
package com.dio.board.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "lanes")
public class Lane {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(nullable = false)
    private String name;

    private Integer wipLimit;

    @Column(nullable = false)
    private Integer orderIndex = 0;

    @OneToMany(mappedBy = "lane", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("orderIndex ASC")
    private List<Card> cards = new ArrayList<>();

    public Lane(){}
    public Lane(Board board, String name, Integer orderIndex){
        this.board = board; this.name = name; this.orderIndex = orderIndex;
    }

    public Long getId(){ return id; }
    public Board getBoard(){ return board; }
    public void setBoard(Board b){ this.board = b; }
    public String getName(){ return name; }
    public void setName(String n){ this.name = n; }
    public Integer getWipLimit(){ return wipLimit; }
    public void setWipLimit(Integer w){ this.wipLimit = w; }
    public Integer getOrderIndex(){ return orderIndex; }
    public void setOrderIndex(Integer i){ this.orderIndex = i; }
    public List<Card> getCards(){ return cards; }
    public void setCards(List<Card> cards){ this.cards = cards; }
}
