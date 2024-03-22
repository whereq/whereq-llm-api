package com.whereq.llm.openai.vo;

import com.whereq.llm.gpt.vo.BaseVO;

public class SimplePromptRequest extends BaseVO {

    private String prompt;

    public SimplePromptRequest() {}

    public SimplePromptRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
