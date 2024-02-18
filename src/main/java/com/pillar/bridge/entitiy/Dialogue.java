package com.pillar.bridge.entitiy;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
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
    private String dialogueId;

    @Column(name = "PLACE", length = 10, nullable = false)
    private String place;

    @ManyToOne
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    private Device device;

    @PrePersist
    public void initializeNanoId() {
        if (dialogueId == null) {
            dialogueId = NanoIdUtils.randomNanoId();
        }
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }

    public String getId() {
        return dialogueId;
    }

    public String getPlace() {
        return place;
    }
}