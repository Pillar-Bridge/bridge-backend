package com.pillar.bridge.dto.TTS;

public class TTSRequest {
    private String text;
    private String lang;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }



}
