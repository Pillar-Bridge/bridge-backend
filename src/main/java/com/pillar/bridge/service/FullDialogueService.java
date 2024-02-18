package com.pillar.bridge.service;

import com.pillar.bridge.dto.FullDialougeDto;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FullDialogueService {

    @Autowired
    private MessageRepository messageRepository;

    public List<FullDialougeDto> getMessagesByDialogueId(String dialogueId) {
        return messageRepository.findByDialogueDialogueIdOrderByTimestampAsc(dialogueId)
                .stream()
                .map(this::mapToMessageResponse)
                .collect(Collectors.toList());
    }

    private FullDialougeDto mapToMessageResponse(Messages message) {
        return new FullDialougeDto(
                message.getMessage_Id(),
                message.getMessage_text(),
                message.getSpeaker(),
                message.getTimestamp() // LocalDateTime을 String으로 변환
        );
    }
}
