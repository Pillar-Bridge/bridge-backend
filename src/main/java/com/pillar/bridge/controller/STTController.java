package com.pillar.bridge.controller;

import com.pillar.bridge.service.STTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/dialogues")
public class STTController {

    private final STTService fastApiService;

    @Autowired
    public STTController(STTService fastApiService) {
        this.fastApiService = fastApiService;
    }

    @PostMapping("/audio")
    public ResponseEntity<String> transcribeAudio(@RequestParam("file") MultipartFile file) {
        String transcription = fastApiService.transcribeAudio(file);
        return ResponseEntity.ok(transcription);
    }
}
