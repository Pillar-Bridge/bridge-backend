package com.pillar.bridge.controller;

import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.NameList;
import com.pillar.bridge.service.RecommendPlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class RecommendPlaceController {

    private final Logger logger = LoggerFactory.getLogger(RecommendPlaceController.class);

    @Autowired
    RecommendPlaceService recommendPlaceService;

    @PostMapping("/places/recommendations")
    public ResponseDto<NameList> searchPlaceByKeywordPost(@RequestBody Map<String, Object> requestBody) {
        double latitude = (double) requestBody.get("latitude");
        double longitude = (double) requestBody.get("longitude");
        int radius = requestBody.containsKey("radius") ? (int) requestBody.get("radius") : 500;

        logger.info("위도 [{}], 경도 [{}], radius [{}]", latitude, longitude, radius);

        NameList nameList = recommendPlaceService.searchPlaceByKeyword(latitude, longitude, radius);
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "Place search successful", nameList);
    }
}


