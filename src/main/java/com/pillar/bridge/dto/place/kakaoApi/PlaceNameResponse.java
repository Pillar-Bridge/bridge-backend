package com.pillar.bridge.dto.place.kakaoApi;

import java.util.List;

public class PlaceNameResponse {
    private Meta meta;
    private List<Document> documents;

    public Meta getMeta() {
        return meta;
    }
    public List<Document> getDocuments() {
        return documents;
    }


    @Override
    public String toString() {
        return "Response{" +
                "meta=" + meta +
                ", documents=" + documents +
                '}';
    }
}
