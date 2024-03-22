package com.whereq.llm.gpt.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseVO {

    String response;

    public BaseVO() {}

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public BaseVO(String response) {
        this.response = response;
    }
}
