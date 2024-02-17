package com.pillar.bridge.controller;

import com.pillar.bridge.dto.TTS.TTSRequest;
import com.pillar.bridge.dto.TTS.TTSResponse;
import com.pillar.bridge.dto.TTSDto;
import com.pillar.bridge.service.TTSService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/convert")
public class TTSController {

    @Autowired
    private TTSService ttsService;

    @PostMapping
    public ResponseEntity<byte[]> textToSpeech(@RequestBody TTSRequest request) {
        ResponseEntity<byte[]> response = ttsService.generateSpeech(request);
        HttpHeaders headers = response.getHeaders();
        return new ResponseEntity<>(response.getBody(), headers, HttpStatus.OK);
    }
}