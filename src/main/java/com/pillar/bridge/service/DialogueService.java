package com.pillar.bridge.service;

import com.pillar.bridge.entitiy.Dialogue;
import com.pillar.bridge.repository.DialogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DialogueService {
    @Autowired
    private DialogueRepository repository;

    public Dialogue createDialogue(String place, String uuid) {
        Dialogue dialogue = new Dialogue();
        dialogue.setPlace(place);
        dialogue.setUuid(uuid);
        return repository.save(dialogue);
    }
}