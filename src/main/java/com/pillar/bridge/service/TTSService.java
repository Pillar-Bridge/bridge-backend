package com.pillar.bridge.service;

import com.pillar.bridge.dto.TTSDto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TTSService {

    public MultipartFile convertTextToSpeech(TTSDto request) {
        RestTemplate restTemplate = new RestTemplate();
        String fastApiUrl = "http://203.253.71.189:5000/tts";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TTSDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ByteArrayResource> response = restTemplate.exchange(
                fastApiUrl, HttpMethod.POST, entity, ByteArrayResource.class);

        ByteArrayResource resource = response.getBody();
        String filename = extractFilename(response.getHeaders().get(HttpHeaders.CONTENT_DISPOSITION));

        return new MockMultipartFile("file", filename, "audio/mpeg", resource.getByteArray());
    }

    private String extractFilename(List<String> contentDisposition) {
        if (contentDisposition != null && !contentDisposition.isEmpty()) {
            String disposition = contentDisposition.get(0);
            Pattern pattern = Pattern.compile("filename=\"(.+?)\"");
            Matcher matcher = pattern.matcher(disposition);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "defaultFilename.mp3"; // 파일 이름을 찾을 수 없는 경우 기본 이름
    }
}