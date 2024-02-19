package com.pillar.bridge.dto.alter;


import java.util.List;

public class WordOption {
    private String word;
    private List<String> options;

    public WordOption() {
    }

    public WordOption(String word, List<String> options) {
        this.word = word;
        this.options = options;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}