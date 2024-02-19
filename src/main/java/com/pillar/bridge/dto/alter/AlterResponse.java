package com.pillar.bridge.dto.alter;

import java.util.List;

public class AlterResponse {
    private List<WordOption> alternatives;
    public AlterResponse(List<WordOption> alternatives) {
        this.alternatives = alternatives;
    }

    public List<WordOption> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<WordOption> alternatives) {
        this.alternatives = alternatives;
    }
}
