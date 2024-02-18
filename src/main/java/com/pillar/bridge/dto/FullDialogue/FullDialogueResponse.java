package com.pillar.bridge.dto.FullDialogue;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullDialogueResponse {
    private String dialogueId;
    private String place; // 장소 정보를 저장하는 필드
    private String situation; // 상황 정보를 저장하는 필드
    private List<FullDialougeDto> messages; // 대화 정보를 저장하는 필드

    public FullDialogueResponse(String dialogueId, String place, String situation, List<FullDialougeDto> messages) {
        this.dialogueId = dialogueId;
        this.place = place;
        this.situation = situation;
        this.messages = messages;
    }
}
