package com.pillar.bridge.controller;
import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.service.STTService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/dialogues")
public class STTController {

    private final STTService sttService;

    @Autowired
    public STTController(STTService sttService) {
        this.sttService = sttService;
    }

    @PostMapping("/audio")
    public ResponseDto<String> transcribeAudio(@RequestParam("file") MultipartFile file) {
        String transcription = sttService.transcribeAudio(file);
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "텍스트 변환 성공", transcription);
    }
}
