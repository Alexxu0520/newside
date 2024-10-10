package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModerationCategoryScores {

    @JsonProperty("hate")
    private double hate;

    @JsonProperty("hate/threatening")
    private double hateThreatening;

    @JsonProperty("harassment")
    private double harassment;

    @JsonProperty("harassment/threatening")
    private double harassmentThreatening;

    @JsonProperty("self-harm")
    private double selfHarm;

    @JsonProperty("self-harm/intent")
    private double selfHarmIntent;

    @JsonProperty("self-harm/instructions")
    private double selfHarmInstructions;

    @JsonProperty("sexual")
    private double sexual;

    @JsonProperty("sexual/minors")
    private double sexualMinors;

    @JsonProperty("violence")
    private double violence;

    @JsonProperty("violence/graphic")
    private double violenceGraphic;

    @JsonProperty("illicit")
    private double illicit;

    @JsonProperty("illicit/violent")
    private double illicitViolent;

    // Getters and setters for all fields

    // Example getter and setter
    public double getHate() {
        return hate;
    }

    public void setHate(double hate) {
        this.hate = hate;
    }

    // ... Implement other getters and setters similarly
}
