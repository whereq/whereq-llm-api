package com.whereq.llm.gpt.vo;

public class GptRequest extends BaseVO {

    private String prompt;

    private GptParameter gptParameter;

    public GptRequest() {}

    public GptRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public GptParameter getGptParameter() {
        return gptParameter;
    }

    public void setGptParameter(GptParameter gptParameter) {
        this.gptParameter = gptParameter;
    }

    @Override
    public String toString() {
        return "GptRequest{" + "prompt='" + prompt + '\'' + ", gptParameter=" + gptParameter + '}';
    }
}
