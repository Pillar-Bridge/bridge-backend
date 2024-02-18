package com.pillar.bridge.service;

import com.pillar.bridge.dto.FullDialogue.FullDialogueDto;
import com.pillar.bridge.dto.FullDialogue.FullDialogueResponseDto;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FullDialogueService {

    @Autowired
    private MessageRepository messageRepository;

    public FullDialogueResponseDto getDialogueDetails(String dialogueId) {
        FullDialogueResponseDto dialogueDetails = new FullDialogueResponseDto();
        dialogueDetails.setDialogueId(dialogueId);
        dialogueDetails.setPlace("카페"); // 수정
        dialogueDetails.setSituation("주문 중"); // 수정

        List<FullDialogueDto> messages = messageRepository.findByDialogueDialogueIdOrderByTimestampAsc(dialogueId)
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
