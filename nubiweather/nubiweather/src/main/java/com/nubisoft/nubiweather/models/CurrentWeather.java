package com.nubisoft.nubiweather.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "CurrentWeather")
public class CurrentWeather {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Embedded
    @JsonProperty("location")
    private Location location;

    @Embedded
    @JsonProperty("current")
    private Current current;

    @Embeddable
    public static class Location {
        @JsonProperty("name")
        private String name;

        @JsonProperty("region")
        private String region;

        @JsonProperty("country")
        private String country;

    }

    @Embeddable
    public static class Current {
        @JsonProperty("temp_c")
        private Double temperatureC;

        @Embedded
        @JsonProperty("condition")
        private Condition condition;

        @Embeddable
        public static class Condition {
            @JsonProperty("text")
            private String text;

        }
    }
}
