package com.whereq.llm.openai.vo.embedding;

import com.whereq.llm.gpt.vo.BaseVO;
import com.whereq.llm.openai.vo.Usage;
import java.util.List;

/**
 * An object containing a response from the answer api
 *
 * https://platform.openai.com/docs/api-reference/embeddings/create
 */
public class EmbeddingResponse extends BaseVO {

    /**
     * The GPTmodel used for generating embeddings
     */
    String model;

    /**
     * The type of object returned, should be "list"
     */
    String object;

    /**
     * A list of the calculated embeddings
     */
    List<Embedding> data;

    /**
     * The API usage for this request
     */
    Usage usage;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Embedding> getData() {
        return data;
    }

    public void setData(List<Embedding> data) {
        this.data = data;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "EmbeddingResponse{" + "model='" + model + '\'' + ", object='" + object + '\'' + ", data=" + data + ", usage=" + usage + '}';
    }
}
