package com.whereq.llm.playground.vo;

public class PlaygroundRequest extends BaseVO {

    private String prompt;

    private PlaygroundParameter playgroundParameter;

    public PlaygroundRequest() {}

    public PlaygroundRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public PlaygroundParameter getGptParameter() {
        return playgroundParameter;
    }

    public void setGptParameter(PlaygroundParameter playgroundParameter) {
        this.playgroundParameter = playgroundParameter;
    }

    @Override
    public String toString() {
        return "GptRequest{" + "prompt='" + prompt + '\'' + ", gptParameter=" + playgroundParameter + '}';
    }
}
