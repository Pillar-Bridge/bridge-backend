package com.pillar.bridge.dto.dialogue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DialogueResponse {

    @JsonProperty("dialogue_id")
    private String id;

    public DialogueResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
