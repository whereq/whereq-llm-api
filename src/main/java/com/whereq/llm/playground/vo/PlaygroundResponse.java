package com.whereq.llm.playground.vo;

public class PlaygroundResponse extends BaseVO {

    private String response;

    private Usage usage;

    public PlaygroundResponse() {}

    public PlaygroundResponse(String response) {
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
