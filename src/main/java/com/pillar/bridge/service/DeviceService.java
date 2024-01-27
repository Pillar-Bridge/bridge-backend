package com.pillar.bridge.service;

import com.pillar.bridge.entitiy.Device;
import com.pillar.bridge.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device registerDevice() {
        Device device = new Device();
        device.setDeviceKey(UUID.randomUUID().toString()); // 고유 KEY 생성

        Logger logger = org.slf4j.LoggerFactory.getLogger(DeviceService.class);
        logger.info("Device Key: " + device.getDeviceKey());
        return deviceRepository.save(device); // 데이터베이스에 저장
    }
}
