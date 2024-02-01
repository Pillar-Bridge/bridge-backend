package com.pillar.bridge.dto;

public class DeviceDto {
    private String deviceKey;

    private String refreshToken;

    public String getDeviceKey() {
        return deviceKey;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
