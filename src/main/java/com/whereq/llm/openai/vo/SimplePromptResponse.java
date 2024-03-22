package com.whereq.llm.openai.vo;

import com.whereq.llm.gpt.vo.BaseVO;

public class SimplePromptResponse extends BaseVO {

    private String response;

    public SimplePromptResponse() {}

    public SimplePromptResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
