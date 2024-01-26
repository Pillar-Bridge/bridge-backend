package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.NameList;
import com.pillar.bridge.service.RecommendPlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RecommendPlaceController {

    private final Logger logger = LoggerFactory.getLogger(RecommendPlaceController.class);

    @Autowired
    RecommendPlaceService recommendPlaceService;

    @PostMapping("/places/recommendations")
    public ResponseEntity<ResponseDto<NameList>> searchPlaceByKeywordPost(@RequestBody Map<String, Object> requestBody) {
        double latitude = (double) requestBody.get("latitude");
        double longitude = (double) requestBody.get("longitude");
        int radius = requestBody.containsKey("radius") ? (int) requestBody.get("radius") : 1000;

        logger.info("/장소 조회 latitude [{}], longitude [{}], radius [{}]", latitude, longitude, radius);

        NameList nameList = recommendPlaceService.searchPlaceByKeyword(latitude, longitude, radius);
        if (nameList != null) {
            // Success case
            ResponseDto<NameList> response = ResponseUtil.SUCCESS(SuccessResponse.OK, "Place search successful", nameList);
            return ResponseEntity.ok(response);
        } else {
            // Error case
            ResponseDto<NameList> response = ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, null);
            return ResponseEntity.badRequest().body(response);
        }
    }
}

