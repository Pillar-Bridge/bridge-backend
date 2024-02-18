package com.pillar.bridge.service;

import com.pillar.bridge.dto.UpdateMessage.UpdateRequest;
import com.pillar.bridge.entitiy.Dialogue;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.DialogueRepository;
import com.pillar.bridge.repository.MessageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UpdateMessageService {

    @Autowired
    private DialogueRepository dialogueRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Messages saveMessage(String dialogueId, UpdateRequest messageDTO) {
        Optional<Dialogue> dialogueOptional = dialogueRepository.findByDialogueId(dialogueId);

        if (!dialogueOptional.isPresent()) {
            throw new EntityNotFoundException("해당 dialogueID는 존재하지 않습니다 " + dialogueId);
        }

        Dialogue dialogue = dialogueOptional.get();

        Messages message = new Messages();
        message.setDialogue(dialogue);
        message.setTimestamp(LocalDateTime.now());
        message.setSpeaker(messageDTO.getSpeaker());
        message.setMessage_text(messageDTO.getText());

        return messageRepository.save(message);
    }
}
