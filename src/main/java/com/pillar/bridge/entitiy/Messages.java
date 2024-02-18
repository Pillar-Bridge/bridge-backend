package com.pillar.bridge.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MESSAGES")
public class Messages {

    @Id
    @Column(name = "message_Id", nullable = false)
    private String message_Id;
    @ManyToOne
    @JoinColumn(name = "dialogueId", referencedColumnName = "dialogueId", nullable = false)
    private Dialogue dialogue;
    private String speaker;
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
    private String message_text;

    @PrePersist
    private void generateUUID() {
        this.message_Id = UUID.randomUUID().toString();
    }

    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void setMessage_text(String messageText) {
        this.message_text = messageText;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage_Id() {
        return message_Id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getMessage_text() {
        return message_text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
