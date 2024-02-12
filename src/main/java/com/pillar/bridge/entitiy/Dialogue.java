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

    @ManyToOne
    @JoinColumn(name = "UUID", referencedColumnName = "UUID", nullable = false)
    private Device device;

    public void setPlace(String place) {
        this.place = place;
    }

    public Device getDevice() {
        return device;
    }


    public long getId(){ return dialogueId;}
    public void setDevice(Device device) {
        this.device = device;
    }
}
