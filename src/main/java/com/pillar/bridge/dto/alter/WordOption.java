package com.pillar.bridge.dto.alter;


import java.util.List;

public class WordOption {
    private String word;
    private List<String> options;

    // 기본 생성자
    public WordOption() {
    }

    // 생성자
    public WordOption(String word, List<String> options) {
        this.word = word;
        this.options = options;
    }

    // getter
    public String getWord() {
        return word;
    }

    // setter
    public void setWord(String word) {
        this.word = word;
    }

    // getter
    public List<String> getOptions() {
        return options;
    }

    // setter
    public void setOptions(List<String> options) {
        this.options = options;
    }
}