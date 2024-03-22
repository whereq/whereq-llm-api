package com.whereq.llm.gpt.vo;

import com.whereq.llm.gpt.enums.*;

public class GptParameter extends BaseVO {

    private String task;
    private String topic;
    private StyleEnum style;
    private ToneEnum tone;
    private AudienceEnum audience;
    private LengthEnum length;
    private FormatEnum format;

    public GptParameter() {}

    public GptParameter(String task, String topic, String style, String tone, String audience, String length, String format) {
        this.task = task;
        this.topic = topic;
        this.style = StyleEnum.fromString(style);
        this.tone = ToneEnum.fromString(tone);
        this.audience = AudienceEnum.fromString(audience);
        this.length = LengthEnum.fromString(length);
        this.format = FormatEnum.fromString(format);
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public StyleEnum getStyle() {
        return style;
    }

    public void setStyle(StyleEnum style) {
        this.style = style;
    }

    public ToneEnum getTone() {
        return tone;
    }

    public void setTone(ToneEnum tone) {
        this.tone = tone;
    }

    public AudienceEnum getAudience() {
        return audience;
    }

    public void setAudience(AudienceEnum audience) {
        this.audience = audience;
    }

    public LengthEnum getLength() {
        return length;
    }

    public void setLength(LengthEnum length) {
        this.length = length;
    }

    public FormatEnum getFormat() {
        return format;
    }

    public void setFormat(FormatEnum format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return (
            "PromptParameter{" +
            "task='" +
            task +
            '\'' +
            ", topic='" +
            topic +
            '\'' +
            ", style='" +
            style +
            '\'' +
            ", tone='" +
            tone +
            '\'' +
            ", audience='" +
            audience +
            '\'' +
            ", length='" +
            length +
            '\'' +
            ", format='" +
            format +
            '\'' +
            '}'
        );
    }
}
