package com.pillar.bridge.service;

import com.pillar.bridge.dto.TTSDto;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.net.URL;

@Service
public class TTSService {

    public Resource getTextToSpeech(TTSDto ttsRequest) throws Exception {
        final String ttsApiUrl = "http://203.253.71.189:5000/tts";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TTSDto> entity = new HttpEntity<>(ttsRequest, headers);
        String filename = restTemplate.exchange(ttsApiUrl, HttpMethod.POST, entity, String.class).getBody(); // API가 파일명을 반환한다고 가정

        URL url = new URL(ttsApiUrl + "/home/bmegpu02/dh/gdsc/tts/res/tts" + filename); // TTS 파일을 다운로드하기 위한 URL 구성
        return new UrlResource(url);
    }
}