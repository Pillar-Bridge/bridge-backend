package com.pillar.bridge.service;

import com.pillar.bridge.dto.DeviceDto;
import com.pillar.bridge.entitiy.Device;
import com.pillar.bridge.repository.DeviceRepository;
import com.pillar.bridge.util.jwt.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private JwtUtil jwtUtil = new JwtUtil();

    private static final Logger logger = LoggerFactory.getLogger(DeviceService.class);


    public DeviceDto registerDevice() {
        Device device = new Device();
        device.setUuid(UUID.randomUUID().toString());

        String accessToken = jwtUtil.generateAccessToken(device.getUuid());
        String refreshToken = jwtUtil.generateRefreshToken(device.getUuid());
        device.setRefreshToken(refreshToken);

        logger.info("Device Key: " + device.getUuid());
        logger.info("Access Token: " + accessToken);
        logger.info("Refresh Token: " + refreshToken);
        deviceRepository.save(device); // DB에 저장

        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setAccessToken(accessToken);
        deviceDto.setRefreshToken(refreshToken);

        return deviceDto;
    }
}
