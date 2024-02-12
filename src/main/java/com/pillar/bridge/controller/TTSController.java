package com.pillar.bridge.controller;

import com.pillar.bridge.dto.TTSDto;
import com.pillar.bridge.service.TTSService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class TTSController {

    @Autowired
    private TTSService ttsService;

}