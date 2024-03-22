package com.whereq.llm.openai.vo.embedding;

import com.whereq.llm.gpt.vo.BaseVO;
import java.util.List;

/**
 * Represents an embedding returned by the embedding api
 *
 * https://platform.openai.com/docs/api-reference/classifications/create
 */
public class Embedding extends BaseVO {

    /**
     * The type of object returned, should be "embedding"
     */
    String object;

    /**
     * The embedding vector
     */
    List<Double> embedding;

    /**
     * The position of this embedding in the list
     */
    Integer index;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Double> getEmbedding() {
        return embedding;
    }

    public void setEmbedding(List<Double> embedding) {
        this.embedding = embedding;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Embedding{" + "object='" + object + '\'' + ", embedding=" + embedding + ", index=" + index + '}';
    }
}
