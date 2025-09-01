
package com.dio.board.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "boards")
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("orderIndex ASC")
    private List<Lane> lanes = new ArrayList<>();

    public Board() {}
    public Board(String name){ this.name = name; }

    public Long getId(){ return id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public List<Lane> getLanes(){ return lanes; }
    public void setLanes(List<Lane> lanes){ this.lanes = lanes; }
}
