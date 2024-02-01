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
    private Integer dialogueId;

    @Column(name = "PLACE", length = 10, nullable = false)
    private String place;

    // Device 엔티티와 연결하기 위한 UUID 필드 추가
    @Column(name = "DEVICE_UUID", nullable = false)
    private String deviceUuid;

    public void setPlace(String place) {
        this.place = place;
    }

    // deviceUuid의 getter와 setter도 추가
    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }
}
