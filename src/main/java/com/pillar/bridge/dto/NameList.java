package com.pillar.bridge.dto;

import com.pillar.bridge.dto.kakaoApi.Document;

import java.util.List;

public class NameList {
    private List<Document> documents;

    public NameList(List<Document> documents) {
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
