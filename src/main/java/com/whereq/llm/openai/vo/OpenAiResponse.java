package com.whereq.llm.openai.vo;

import java.util.List;

/**
 * A wrapper class to fit the OpenAI engine and search endpoints
 */
public class OpenAiResponse<T> {

    /**
     * A list containing the actual results
     */
    public List<T> data;

    /**
     * The type of object returned, should be "list"
     */
    public String object;

    @Override
    public String toString() {
        return "OpenAiResponse{" + "data=" + data + ", object='" + object + '\'' + '}';
    }
}
