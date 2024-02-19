package com.pillar.bridge.service;

import com.pillar.bridge.dto.alter.AlterResponse;
import com.pillar.bridge.dto.alter.AlterRequest;
import com.pillar.bridge.dto.alter.WordOption;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AlterService{

    public AlterResponse getOptions(AlterRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String externalApiUrl = "http://203.253.71.189:5000/alter"; // 실제 외부 API 주소로 변경해야 합니다.

        // 외부 API로부터 응답 받기
        WordOption[] response = restTemplate.postForObject(externalApiUrl, request, WordOption[].class);

        // 응답을 AlternativeResponse 형태로 변환
        List<WordOption> wordOptions = Arrays.asList(response);
        AlterResponse alternativeResponse = new AlterResponse(wordOptions);

        return alternativeResponse;
    }
}