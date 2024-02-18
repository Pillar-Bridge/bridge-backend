package com.pillar.bridge.service;

import com.pillar.bridge.dto.PlacesDto;
import com.pillar.bridge.dto.place.googleApi.PlacesRequest;
import com.pillar.bridge.dto.place.googleApi.PlacesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecommPlaceGoogleService {
    @Value("${google.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;
    public RecommPlaceGoogleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PlacesResponse searchNearbyPlaces(PlacesDto simpleRequest) {
        PlacesRequest request = convertToNearbySearchRequest(simpleRequest);

        String url = "https://places.googleapis.com/v1/places:searchNearby";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-Goog-Api-Key", apiKey);
        headers.add("X-Goog-FieldMask", "places.displayName,places.primaryType");

        HttpEntity<PlacesRequest> entity = new HttpEntity<>(request, headers);
        return restTemplate.postForEntity(url, entity, PlacesResponse.class).getBody();
    }

    private PlacesRequest convertToNearbySearchRequest(PlacesDto placesDto) {
        PlacesRequest.LocationRestriction.Circle.Center center = new PlacesRequest.LocationRestriction.Circle.Center(
                placesDto.getLatitude(), placesDto.getLongitude());
        PlacesRequest.LocationRestriction.Circle circle = new PlacesRequest.LocationRestriction.Circle(center, 1000.0);
        PlacesRequest.LocationRestriction locationRestriction = new PlacesRequest.LocationRestriction(circle);

        return new PlacesRequest(List.of("convenience_store", "restaurant"), 10, "DISTANCE", locationRestriction);
    }
}
