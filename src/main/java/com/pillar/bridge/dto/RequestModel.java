package com.pillar.bridge.dto;

public class RequestModel {
    private String place;
    private String text;
    private String lang;

    // 기본 생성자
    public RequestModel() {}

    // 매개변수를 가진 생성자
    public RequestModel(String place, String text, String lang) {
        this.place = place;
        this.text = text;
        this.lang = lang;
    }

    // Getter 및 Setter
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
