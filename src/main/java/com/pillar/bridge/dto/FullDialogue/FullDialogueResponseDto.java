package com.pillar.bridge.dto.FullDialogue;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullDialogueResponseDto {
    private String dialogueId;
    private String place;
    private String situation;
    private List<FullDialogueDto> messages;

    public FullDialogueResponseDto(String dialogueId, String place, String situation, List<FullDialogueDto> messages) {
        this.dialogueId = dialogueId;
        this.place = place;
        this.situation = situation;
        this.messages = messages;
    }

    public FullDialogueResponseDto() {

    }

    public void setDialogueId(String dialogueId) {
        this.dialogueId = dialogueId;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public void setMessages(List<FullDialogueDto> messages) {
        this.messages = messages;
    }

    // Getters and Setters
}
