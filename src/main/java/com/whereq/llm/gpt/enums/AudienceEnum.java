package com.whereq.llm.gpt.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AudienceEnum {
    Default("default"),
    All("all"),
    Adult("adult"),
    Teenager("teenager"),
    Kid("kid"),
    Elder("elder"),
    Business("business"),
    Expert("expert"),
    Hostile("hostile"),
    Neutral("neutral"),
    Boss("boss"),
    Teacher("teacher"),
    Parent("parent"),
    Partner("partner"),
    Child("child"),
    Colleague("colleague"),
    Friend("friend");

    private String audience;

    AudienceEnum(String audience) {
        this.audience = audience;
    }

    public String getAudience() {
        return audience;
    }

    @JsonCreator
    public static AudienceEnum fromString(String audience) {
        for (AudienceEnum audienceEnum : AudienceEnum.values()) {
            if (audienceEnum.audience.equalsIgnoreCase(audience)) {
                return audienceEnum;
            }
        }
        return AudienceEnum.All;
    }
}
