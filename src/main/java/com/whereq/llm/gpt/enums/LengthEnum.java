package com.whereq.llm.gpt.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum LengthEnum {
    LENGTH_DEFAULT("default"),
    LENGTH_MAX("max"),
    LENGTH_1_PARAGRAPH("1 paragraph"),
    LENGTH_2_PARAGRAPH("2 paragraph"),
    LENGTH_3_PARAGRAPH("3 paragraph"),
    LENGTH_20_WORDS("20 words"),
    LENGTH_50_WORDS("50 words"),
    LENGTH_100_WORDS("100 words"),
    LENGTH_200_WORDS("200 words"),
    LENGTH_500_WORDS("500 words");

    private String value;

    LengthEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator
    public static LengthEnum fromString(String description) {
        for (LengthEnum lengthEnum : LengthEnum.values()) {
            if (lengthEnum.value.equalsIgnoreCase(description)) {
                return lengthEnum;
            }
        }
        return LengthEnum.LENGTH_DEFAULT;
    }
}
