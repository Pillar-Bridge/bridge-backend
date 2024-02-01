package com.pillar.bridge.controller;

import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.PlacesDto;
import com.pillar.bridge.dto.googleApi.PlacesResponse;
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

    @PostMapping("/places/recommendations/google")
    public ResponseDto<PlacesResponse> searchNearby(@RequestBody PlacesDto request) {
        try {
            PlacesResponse response = placesService.searchNearbyPlaces(request);
            return ResponseUtil.SUCCESS(SuccessResponse.OK, "Successfully retrieved data", response);
        } catch (Exception e) {
            return ResponseUtil.FAILED(ErrorResponse.INTERNAL_SERVER_ERROR, null);
        }
    }

}
