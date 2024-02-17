package com.pillar.bridge.service;

import com.pillar.bridge.dto.TTS.TTSRequest;
import com.pillar.bridge.dto.TTS.TTSResponse;
import com.pillar.bridge.dto.TTSDto;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@Service
public class TTSService {

    public ResponseEntity<byte[]> generateSpeech(TTSRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TTSRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<byte[]> response = restTemplate.postForEntity("http://203.253.71.189:5000/tts", entity, byte[].class);

        return response;
    }
}