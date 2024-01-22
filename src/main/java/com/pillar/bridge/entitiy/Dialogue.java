package com.pillar.bridge.entitiy;

import jakarta.persistence.*;

@Entity
@Table(name = "DIALOGUES")
public class Dialogue {
    @Id
    @Column(name = "DIALOGUE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dialogueId;

    @Column(name = "PLACE")
    private String place;


    public void setPlace(String place) {
        this.place = place;
    }
}