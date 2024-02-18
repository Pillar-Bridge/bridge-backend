package com.pillar.bridge.service;

import com.pillar.bridge.dto.UpdateMessage.UpdateRequest;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Messages saveMessage(String dialogueId, UpdateRequest messageDTO) {
        Messages message = new Messages();
        message.setDialogueId(dialogueId);
        message.setTimestamp(LocalDateTime.now());
        message.setSpeaker(messageDTO.getSpeaker());
        message.setMessage_text(messageDTO.getText());

        return messageRepository.save(message); // 설정된 객체를 데이터베이스에 저장
    }
}
