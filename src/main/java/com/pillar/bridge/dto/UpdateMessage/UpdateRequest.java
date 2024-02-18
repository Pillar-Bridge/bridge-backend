package com.pillar.bridge.dto.UpdateMessage;

public class UpdateRequest {
    private String speaker;
    private String text;
    private String lang;

    public UpdateRequest(){

    }

    public UpdateRequest(String speaker, String text, String lang){
        this.speaker = speaker;
        this.text = text;
        this.lang = lang;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

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
