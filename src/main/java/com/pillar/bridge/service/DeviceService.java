package com.pillar.bridge.service;

import com.pillar.bridge.entitiy.Device;
import com.pillar.bridge.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device saveDeviceIfNotExists(String uuid) {
        Optional<Device> existingDevice = deviceRepository.findByUuid(uuid);

        return existingDevice.orElseGet(() -> {
            Device newDevice = new Device();
            newDevice.setUuid(uuid);
            return deviceRepository.save(newDevice);
        });
    }
}