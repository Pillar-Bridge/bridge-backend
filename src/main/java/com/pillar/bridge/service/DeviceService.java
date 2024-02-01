package com.pillar.bridge.service;

import com.pillar.bridge.dto.DeviceDto;
import com.pillar.bridge.entitiy.Device;
import com.pillar.bridge.repository.DeviceRepository;
import com.pillar.bridge.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;



    private static final Logger logger = LoggerFactory.getLogger(DeviceService.class);
    private JwtUtil jwtUtil = new JwtUtil();

    public DeviceDto registerDevice() {
        Device device = new Device();
        device.setDeviceKey(UUID.randomUUID().toString());

        // JWT 기반 Refresh Token 생성
        String refreshToken = jwtUtil.generateRefreshToken(device.getDeviceKey());

        logger.info("Device Key: " + device.getDeviceKey());
        logger.info("Refresh Token: " + refreshToken);
        deviceRepository.save(device);

        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setDeviceKey(device.getDeviceKey());
        deviceDto.setRefreshToken(refreshToken);

        return deviceDto;
    }
}
