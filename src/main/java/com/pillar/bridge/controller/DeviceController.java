package com.pillar.bridge.controller;

import com.pillar.bridge.entitiy.Device;
import com.pillar.bridge.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/register")
    public ResponseEntity<Device> registerDevice() {
        Device device = deviceService.registerDevice();
        return ResponseEntity.ok(device); // 등록된 기기 정보 반환
    }
}
