package com.pillar.bridge.dto.dialogue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DialogueResponse {

    @JsonProperty("dialogue_id")
    private long id;

    public DialogueResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
