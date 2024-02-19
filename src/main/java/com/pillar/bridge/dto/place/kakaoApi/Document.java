package com.pillar.bridge.dto.place.kakaoApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {

    @JsonProperty("place_name")
    private String placeName;

    @JsonProperty("category_group_name")
    private String categoryGroupName;

    public String getPlaceName() {
        return placeName;
    }

    public String getCategoryGroupName() {
        return categoryGroupName;
    }

    @Override
    public String toString() {
        return "Document{" +
                "placeName='" + placeName + '\'' +
                ", categoryGroupName='" + categoryGroupName + '\'' +
                '}';
    }
}
