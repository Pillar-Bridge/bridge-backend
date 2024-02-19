package com.pillar.bridge.dto.place.googleApi;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleResponse {
    private List<Place> places;
    public GoogleResponse() {}
    public GoogleResponse(List<Place> places) {
        this.places = places;
    }
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public static class Place {
        private DisplayName displayName;

        private String primaryType;

        public Place() {}

        public Place(DisplayName displayName, String primaryType) {
            this.displayName = displayName;
            this.primaryType = primaryType;
        }

        public DisplayName getDisplayName() {
            return displayName;
        }

        public void setDisplayName(DisplayName displayName) {
            this.displayName = displayName;
        }

        public String getPrimaryType() {
            return primaryType;
        }

        public void setPrimaryType(String primaryType) {
            this.primaryType = primaryType;
        }

        public static class DisplayName {

            private String text;

            public DisplayName() {}

            public DisplayName(String text) {
                this.text = text;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

        }

    }

    public List<PlaceResponse> convertToPlaceResponseDto() {
        return this.places.stream()
                .map(place -> new PlaceResponse(place.getDisplayName().getText(), place.getPrimaryType()))
                .collect(Collectors.toList());
    }
}
