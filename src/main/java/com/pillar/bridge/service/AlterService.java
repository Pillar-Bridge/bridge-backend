package com.pillar.bridge.service;

import com.pillar.bridge.dto.alter.AlterResponse;
import com.pillar.bridge.dto.alter.AlterRequest;
import com.pillar.bridge.dto.alter.WordOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AlterService{

    @Value("${ai.server.url}")
    private String baseUrl;

    public AlterResponse getOptions(AlterRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        String fullUrl = baseUrl + "/alter";

        WordOption[] response = restTemplate.postForObject(fullUrl, request, WordOption[].class);

        List<WordOption> wordOptions = Arrays.asList(response);
        AlterResponse alterResponse = new AlterResponse(wordOptions);

        return alterResponse;
    }
}