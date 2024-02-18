package com.pillar.bridge.service;

import com.pillar.bridge.entitiy.Device;
import com.pillar.bridge.entitiy.Dialogue;
import com.pillar.bridge.repository.DeviceRepository;
import com.pillar.bridge.repository.DialogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DialogueService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DialogueRepository dialogueRepository;

    @Autowired
    private DeviceService deviceService;

    public Dialogue createDialogue(String place, String uuid) {
        Device device = deviceService.saveDeviceIfNotExists(uuid);

        Dialogue dialogue = new Dialogue();
        dialogue.setPlace(place);
        dialogue.setDevice(device);
        return dialogueRepository.save(dialogue);
    }
}
