package com.pillar.bridge.dto.alter;

public class AlterRequest {
    private String sentence;

    // 기본 생성자
    public AlterRequest() {
    }

    // 생성자
    public AlterRequest(String sentence) {
        this.sentence = sentence;
    }

    // getter
    public String getSentence() {
        return sentence;
    }

    // setter
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
