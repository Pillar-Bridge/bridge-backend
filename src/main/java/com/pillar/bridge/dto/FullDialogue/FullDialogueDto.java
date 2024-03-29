package com.pillar.bridge.dto.FullDialogue;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FullDialogueDto {
    private String messageId;
    private String text;
    private String speaker;
    private LocalDateTime createdAt;


    public FullDialogueDto(String messageId, String text, String speaker, LocalDateTime createdAt) {
        this.messageId = messageId;
        this.text = text;
        this.speaker = speaker;
        this.createdAt = createdAt;
    }
}