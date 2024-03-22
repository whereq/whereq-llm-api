package com.whereq.llm.gpt.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FormatEnum {
    Default("default"),
    Text("text"),
    HTML("html"),
    JSON("json"),
    Markdown("markdown"),
    XML("xml"),
    CSV("csv");

    private String format;

    FormatEnum(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    @JsonCreator
    public static FormatEnum fromString(String format) {
        for (FormatEnum formatEnum : FormatEnum.values()) {
            if (formatEnum.format.equalsIgnoreCase(format)) {
                return formatEnum;
            }
        }
        return FormatEnum.Text;
    }
}
