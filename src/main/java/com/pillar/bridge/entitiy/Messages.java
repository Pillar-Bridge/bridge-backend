package com.pillar.bridge.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MESSAGES")
public class Messages {

    @Id
    private Integer message_Id;

    // foreign key dialogue_Id
    private Integer dialogue_Id;

    private String speaker;

    // 타임스탬프
    private Integer timestamp;

    // 메시지
    private String message_text;


    public void setDialogue_Id(Integer dialogue_Id) {
        this.dialogue_Id = dialogue_Id;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public Integer getDialogue_Id() {
        return dialogue_Id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public String getMessage_text() {
        return message_text;
    }






}
