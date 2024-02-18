package com.pillar.bridge.service;

import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired
    private MessageRepository messagesRepository;

    public String getLatestMessageText(String dialogueId) {
        return messagesRepository.findByDialogueId(dialogueId).stream()
                .findFirst() // 첫 번째 요소(가장 최근 메시지)를 가져옴
                .map(Messages::getMessage_text)
                .orElse("No message found for the given Dialogue ID");
    }
}
