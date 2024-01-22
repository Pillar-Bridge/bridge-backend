package com.pillar.bridge.controller;

import com.pillar.bridge.dto.DialogueDto;
import com.pillar.bridge.service.DialogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dialogues")
public class DialogueController {
    @Autowired
    private DialogueService service;

    @PostMapping
    public ResponseEntity<String> createDialogue(@RequestBody DialogueDto dialogueDto) {
        service.createDialogue(dialogueDto.getPlace());
        return ResponseEntity.ok("OK");
    }
}
