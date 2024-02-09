package com.pillar.bridge.service.Device;

import com.pillar.bridge.entitiy.Device;
import com.pillar.bridge.repository.DeviceRepository;
import com.pillar.bridge.util.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceRefreshService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DeviceRepository deviceRepository;

    public String refreshToken(String refreshToken) {
        if (refreshToken != null) {
            Optional<Device> deviceOptional = deviceRepository.findByRefreshToken(refreshToken);

            if (deviceOptional.isPresent() && jwtUtil.validateToken(refreshToken)) {
                Device device = deviceOptional.get();
                return jwtUtil.generateAccessToken(device.getUuid());
            }
        }
        return null;
    }
}