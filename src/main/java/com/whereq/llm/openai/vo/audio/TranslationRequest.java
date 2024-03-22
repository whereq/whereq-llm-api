package com.whereq.llm.openai.vo.audio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whereq.llm.gpt.vo.BaseVO;

/**
 * A request for OpenAi to turn an audio file into text.
 *
 * https://platform.openai.com/docs/api-reference/audio
 */
public class TranslationRequest extends BaseVO {

    private String model;
    private String file;
    private String prompt;

    @JsonProperty("response_format")
    private String responseFormat;

    private Double temperature;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return (
            "TranscriptionRequest{" +
            "model='" +
            model +
            '\'' +
            ", file='" +
            file +
            '\'' +
            ", prompt='" +
            prompt +
            '\'' +
            ", responseFormat='" +
            responseFormat +
            '\'' +
            ", temperature=" +
            temperature +
            '}'
        );
    }
}
