package com.pillar.bridge.controller;

import com.pillar.bridge.dto.TTSDto;
import com.pillar.bridge.service.TTSService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class TTSController {

    @Autowired
    private TTSService ttsService;
    public TTSController(TTSService ttsService) {
        this.ttsService = ttsService;
    }

    @PostMapping("/tts")
    public ResponseEntity<Resource> createTTS(@RequestBody TTSDto ttsRequest) throws Exception {
        Resource ttsFile = ttsService.getTextToSpeech(ttsRequest);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/tts/download/")
                .path(ttsFile.getFilename())
                .toUriString();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ttsFile.getFilename() + "\"")
                .body(ttsFile);
    }

}