package com.pillar.bridge.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class STTService {

    private final RestTemplate restTemplate;
    private final String fastApiBaseUrl = "http://203.253.71.189:5000";

    public STTService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String transcribeAudio(MultipartFile file) {
        String url = fastApiBaseUrl + "/stt";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        return response.getBody();
    }
}
