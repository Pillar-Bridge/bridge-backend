package com.pillar.bridge.service;

import com.pillar.bridge.dto.RequestModel;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReplyService {

    @Autowired
    private MessageRepository messagesRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String getLatestMessageText(String dialogueId) {
        return messagesRepository.findByDialogueId(dialogueId).stream()
                .findFirst() // 첫 번째 요소(가장 최근 메시지)를 가져옴
                .map(Messages::getMessage_text)
                .orElse("No message found for the given Dialogue ID");
    }

    public String getRecommendation(String dialogueId) {
        String messageText = getLatestMessageText(dialogueId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestModel request = new RequestModel("cafe", messageText, "en");
        HttpEntity<RequestModel> requestEntity = new HttpEntity<>(request, headers);

        String fastApiUrl = "http://203.253.71.189:5000/recomm";
        String response = restTemplate.postForObject(fastApiUrl, requestEntity, String.class);

        return response;
    }
}
