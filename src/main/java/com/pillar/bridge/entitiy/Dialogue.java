package com.pillar.bridge.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIALOGUES")
public class Dialogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dialogue_Id;

    @Column(name = "PLACE", length = 10, nullable = false)
    private String place;


    public void setPlace(String place) {
        this.place = place;
    }
}