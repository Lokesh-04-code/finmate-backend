package com.lokesh.finmate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {

    @JsonProperty("Food")
    private double food;

    @JsonProperty("Transport")
    private double transport;

    @JsonProperty("Healthcare")
    private double healthcare;

    @JsonProperty("Personal")
    private double personal;

    @JsonProperty("Education")
    private double education;

    @JsonProperty("Utilities")
    private double utilities;

    @JsonProperty("Clothes")
    private double clothes;

    @JsonProperty("Other")
    private double other;
}
