package com.pillar.bridge.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FullDialougeDto {
    private String messageId;
    private String text;
    private String speaker;
    private LocalDateTime createdAt;


    public FullDialougeDto(String messageId, String text, String speaker, LocalDateTime createdAt) {
        this.messageId = messageId;
        this.text = text;
        this.speaker = speaker;
        this.createdAt = createdAt;
    }

    // Getters and Setters
}