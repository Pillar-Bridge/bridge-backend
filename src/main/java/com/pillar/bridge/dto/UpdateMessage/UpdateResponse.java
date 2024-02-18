package com.pillar.bridge.dto.UpdateMessage;

public class UpdateResponse {
    private String message_Id;
    private String speaker;
    private String message_text;

    // 생성자
    public UpdateResponse(String message_Id, String speaker, String message_text) {
        this.message_Id = message_Id;
        this.speaker = speaker;
        this.message_text = message_text;
    }

    // 게터 메소드
    public String getMessage_Id() {
        return message_Id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getMessage_text() {
        return message_text;
    }
}