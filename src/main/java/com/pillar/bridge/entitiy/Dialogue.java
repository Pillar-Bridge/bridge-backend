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
    private long dialogueId;

    @Column(name = "PLACE", length = 10, nullable = false)
    private String place;

    @Column(nullable = false)
    private String uuid;

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUuid() {
        return uuid;
    }
    public long getId(){ return dialogueId;}
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}