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

    @Column(name = "UUID", nullable = false)
    private String deviceUuid;


    public void setPlace(String place) {
        this.place = place;
    }

    public String getUuid() {
        return deviceUuid;
    }

    public long getId(){ return dialogueId;}
    public void setUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }
}
