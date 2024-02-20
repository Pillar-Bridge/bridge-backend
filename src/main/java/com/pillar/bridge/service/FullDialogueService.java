package com.pillar.bridge.service;

import com.pillar.bridge.dto.FullDialogue.FullDialogueDto;
import com.pillar.bridge.dto.FullDialogue.FullDialogueResponseDto;
import com.pillar.bridge.entitiy.Dialogue;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.DialogueRepository;
import com.pillar.bridge.repository.MessageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FullDialogueService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private DialogueRepository dialogueRepository;

    public FullDialogueResponseDto getDialogueDetails(String dialogueId) {
        FullDialogueResponseDto dialogueDetails = new FullDialogueResponseDto();
        dialogueDetails.setDialogueId(dialogueId);

        Dialogue dialogue = dialogueRepository.findById(dialogueId).orElseThrow(
                () -> new EntityNotFoundException(dialogueId + "is not found.")
        );
        dialogueDetails.setPlace(dialogue.getPlace());
        dialogueDetails.setSituation(dialogue.getSituation());

        dialogueDetails.setSituation(dialogue.getSituation());

        List<FullDialogueDto> messages = messageRepository.findByTimeASC(dialogueId)
                .stream()
                .map(this::mapToMessageResponse)
                .collect(Collectors.toList());

        dialogueDetails.setMessages(messages);
        return dialogueDetails;
    }

    private FullDialogueDto mapToMessageResponse(Messages message) {
        return new FullDialogueDto(
                message.getMessage_Id(),
                message.getMessage_text(),
                message.getSpeaker(),
                message.getTimestamp()
        );
    }
}
