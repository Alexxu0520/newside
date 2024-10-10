package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModerationCategories {

    @JsonProperty("hate")
    private boolean hate;

    @JsonProperty("hate/threatening")
    private boolean hateThreatening;

    @JsonProperty("harassment")
    private boolean harassment;

    @JsonProperty("harassment/threatening")
    private boolean harassmentThreatening;

    @JsonProperty("self-harm")
    private boolean selfHarm;

    @JsonProperty("self-harm/intent")
    private boolean selfHarmIntent;

    @JsonProperty("self-harm/instructions")
    private boolean selfHarmInstructions;

    @JsonProperty("sexual")
    private boolean sexual;

    @JsonProperty("sexual/minors")
    private boolean sexualMinors;

    @JsonProperty("violence")
    private boolean violence;

    @JsonProperty("violence/graphic")
    private boolean violenceGraphic;

    @JsonProperty("illicit")
    private boolean illicit;

    @JsonProperty("illicit/violent")
    private boolean illicitViolent;

    // Getters and setters for all fields

    // Example getter and setter
    public boolean isHate() {
        return hate;
    }

    public void setHate(boolean hate) {
        this.hate = hate;
    }

    public boolean isViolence() {
        return violence;
    }

    // ... Implement other getters and setters similarly
}
