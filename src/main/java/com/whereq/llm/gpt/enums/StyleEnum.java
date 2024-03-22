package com.whereq.llm.gpt.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StyleEnum {
    Default("default", 1.0),
    Academic("academic", 0.7),
    Business("business", 0.6),
    Casual("casual", 0.9),
    Creative("creative", 0.8),
    Descriptive("descriptive", 0.7),
    Emotional("emotional", 0.9),
    Expository("expository", 0.6),
    Formal("formal", 0.5),
    Informal("informal", 0.9),
    Legal("legal", 0.5),
    Medical("medical", 0.5),
    Narrative("narrative", 0.8),
    Persuasive("persuasive", 0.7),
    Poetic("poetic", 0.9),
    Technical("technical", 0.6);

    private String style;
    private Double value;

    StyleEnum(String style, Double value) {
        this.style = style;
        this.value = value;
    }

    public String getStyle() {
        return style;
    }

    public Double getValue() {
        return value;
    }

    @JsonCreator
    public static StyleEnum fromString(String style) {
        for (StyleEnum styleEnum : StyleEnum.values()) {
            if (styleEnum.style.equalsIgnoreCase(style)) {
                return styleEnum;
            }
        }
        return StyleEnum.Casual;
    }
}
