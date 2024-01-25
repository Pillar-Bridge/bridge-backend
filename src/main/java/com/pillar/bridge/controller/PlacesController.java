package com.pillar.bridge.controller;

import com.pillar.bridge.dto.NearbySearchRequest;
import com.pillar.bridge.dto.NearbySearchResponse;
import com.pillar.bridge.service.PlacesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacesController {

    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @PostMapping("/searchNearby")
    public NearbySearchResponse searchNearby(@RequestBody NearbySearchRequest request) {
        return placesService.searchNearbyPlaces(request);
    }
}
