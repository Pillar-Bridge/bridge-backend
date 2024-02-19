package com.pillar.bridge.service;

import com.pillar.bridge.dto.TTS.TTSRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TTSService {

    @Value("${ai.server.url}")
    private String baseUrl;

    public ResponseEntity<byte[]> generateSpeech(TTSRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String fullUrl = baseUrl + "/tts";

        HttpEntity<TTSRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<byte[]> response = restTemplate.postForEntity(fullUrl, entity, byte[].class);

        return response;
    }
}