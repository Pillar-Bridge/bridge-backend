package com.pillar.bridge.dto.TTS;

public class TTSResponse {

    private byte[] audioContent;

    public TTSResponse(byte[] audioContent) {
        this.audioContent = audioContent;
    }

    public byte[] getAudioContent() {
        return audioContent;
    }

}
