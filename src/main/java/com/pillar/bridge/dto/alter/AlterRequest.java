package com.pillar.bridge.dto.alter;

public class AlterRequest {
    private String sentence;

    public AlterRequest() {
    }

    public AlterRequest(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
