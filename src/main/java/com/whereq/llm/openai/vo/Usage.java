package com.whereq.llm.openai.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whereq.llm.gpt.vo.BaseVO;

/**
 * The OpenAI resources used by a request
 */
public class Usage extends BaseVO {

    /**
     * The number of prompt tokens used.
     */
    @JsonProperty("prompt_tokens")
    long promptTokens;

    /**
     * The number of completion tokens used.
     */
    @JsonProperty("completion_tokens")
    long completionTokens;

    /**
     * The number of total tokens used
     */
    @JsonProperty("total_tokens")
    long totalTokens;

    @Override
    public String toString() {
        return "Usage{" + "promptTokens=" + promptTokens + ", completionTokens=" + completionTokens + ", totalTokens=" + totalTokens + '}';
    }
}
