package com.whereq.llm.gpt.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ToneEnum {
    Default("default", 1.0),
    Analytical("analytical", 0.8),
    Angry("angry", 0.2),
    Assertive("assertive", 0.5),
    Confident("confident", 0.6),
    Cooperative("cooperative", 0.8),
    Curious("curious", 0.7),
    Empathetic("empathetic", 0.9),
    Encouraging("encouraging", 0.8),
    Enthusiastic("enthusiastic", 0.8),
    Excited("excited", 0.8),
    Friendly("friendly", 0.9),
    Joyful("joyful", 0.8),
    Optimistic("optimistic", 0.8),
    Professional("professional", 0.7),
    Sad("sad", 0.2),
    Serious("serious", 0.6),
    Surprised("surprised", 0.7),
    Tentative("tentative", 0.5),
    Worried("worried", 0.3);

    private String tone;
    private Double value;

    ToneEnum(String tone, Double value) {
        this.tone = tone;
        this.value = value;
    }

    public String getTone() {
        return tone;
    }

    public Double getValue() {
        return value;
    }

    @JsonCreator
    public static ToneEnum fromString(String tone) {
        for (ToneEnum toneEnum : ToneEnum.values()) {
            if (toneEnum.tone.equalsIgnoreCase(tone)) {
                return toneEnum;
            }
        }
        return ToneEnum.Friendly;
    }
}
