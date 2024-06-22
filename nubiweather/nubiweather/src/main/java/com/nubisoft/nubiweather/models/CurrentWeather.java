package com.nubisoft.nubiweather.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentWeather {
    @JsonProperty("location")
    private Location location;

    @JsonProperty("current")
    private Current current;

    public static class Location {
        @JsonProperty("name")
        private String name;

        @JsonProperty("region")
        private String region;

        @JsonProperty("country")
        private String country;

    }

    public static class Current {
        @JsonProperty("temp_c")
        private Double temperatureC;

        @JsonProperty("condition")
        private Condition condition;

        public static class Condition {
            @JsonProperty("text")
            private String text;

        }
    }
}
