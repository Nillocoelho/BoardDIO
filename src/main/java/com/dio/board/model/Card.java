
package com.dio.board.model;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lane_id")
    private Lane lane;

    @Column(nullable = false)
    private String title;

    private String description;

    private LocalDate dueDate;

    @Column(nullable = false)
    private Integer orderIndex = 0;

    private String priority; // LOW, MEDIUM, HIGH (livre)

    private LocalDateTime createdAt = LocalDateTime.now();

    public Card(){}
    public Card(Lane lane, String title, Integer orderIndex){
        this.lane = lane; this.title = title; this.orderIndex = orderIndex;
    }

    public Long getId(){ return id; }
    public Lane getLane(){ return lane; }
    public void setLane(Lane lane){ this.lane = lane; }
    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }
    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }
    public LocalDate getDueDate(){ return dueDate; }
    public void setDueDate(LocalDate dueDate){ this.dueDate = dueDate; }
    public Integer getOrderIndex(){ return orderIndex; }
    public void setOrderIndex(Integer orderIndex){ this.orderIndex = orderIndex; }
    public String getPriority(){ return priority; }
    public void setPriority(String priority){ this.priority = priority; }
    public LocalDateTime getCreatedAt(){ return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt){ this.createdAt = createdAt; }
}
