package com.pillar.bridge.controller;

import com.pillar.bridge.dto.FullDialogue.FullDialougeDto;
import com.pillar.bridge.service.FullDialogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FullDialogueController {

    @Autowired
    private FullDialogueService fullDialogueService;

    @GetMapping("/dialogue/{dialogueId}")
    public List<FullDialougeDto> getMessagesByDialogueId(@PathVariable("dialogueId") String dialogueId) {
        return fullDialogueService.getMessagesByDialogueId(dialogueId);
    }
}