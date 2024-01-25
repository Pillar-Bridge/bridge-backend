package com.pillar.bridge.service;

import com.pillar.bridge.dto.NearbySearchRequest;
import com.pillar.bridge.dto.NearbySearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlacesService {

    @Value("${google.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public PlacesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NearbySearchResponse searchNearbyPlaces(NearbySearchRequest request) {
        String url = "https://places.googleapis.com/v1/places:searchNearby";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-Goog-Api-Key", apiKey);
        headers.add("X-Goog-FieldMask", "places.displayName");

        HttpEntity<NearbySearchRequest> entity = new HttpEntity<>(request, headers);
        return restTemplate.postForEntity(url, entity, NearbySearchResponse.class).getBody();
    }
}
