package com.whereq.llm.openai.vo.embedding;

import com.whereq.llm.gpt.vo.BaseVO;
import java.util.List;

/**
 * Creates an embedding vector representing the input text.
 *
 * https://platform.openai.com/docs/api-reference/embeddings/create
 */
public class EmbeddingRequest extends BaseVO {

    /**
     * The name of the model to use.
     * Required if using the new v1/embeddings endpoint.
     */
    String model;

    /**
     * Input text to get embeddings for, encoded as a string or array of tokens.
     * To get embeddings for multiple inputs in a single request, pass an array of strings or array of token arrays.
     * Each input must not exceed 2048 tokens in length.
     * <p>
     * Unless you are embedding code, we suggest replacing newlines (\n) in your input with a single space,
     * as we have observed inferior results when newlines are present.
     */
    //    @NonNull
    List<String> input;

    /**
     * A unique identifier representing your end-user, which will help OpenAI to monitor and detect abuse.
     */
    String user;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmbeddingRequest{" + "model='" + model + '\'' + ", input=" + input + ", user='" + user + '\'' + '}';
    }
}
