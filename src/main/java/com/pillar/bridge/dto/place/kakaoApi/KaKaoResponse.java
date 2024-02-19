package com.pillar.bridge.dto.place.kakaoApi;

import com.pillar.bridge.dto.place.kakaoApi.Document;

import java.util.List;

public class KaKaoResponse {
    private List<Document> documents;

    public KaKaoResponse(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "NameList{" +
                "documents=" + documents +
                '}';
    }



}
