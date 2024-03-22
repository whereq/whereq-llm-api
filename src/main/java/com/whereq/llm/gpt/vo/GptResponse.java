package com.whereq.llm.gpt.vo;

public class GptResponse extends BaseVO {

    private String response;

    private Usage usage;

    public GptResponse() {}

    public GptResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
