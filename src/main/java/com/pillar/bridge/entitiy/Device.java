package com.pillar.bridge.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid;
    @Column(nullable = false)
    private String refreshToken;

    public String getUuid() {
        return uuid;
    }
    public String getRefreshToken() { return refreshToken; }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }

}
