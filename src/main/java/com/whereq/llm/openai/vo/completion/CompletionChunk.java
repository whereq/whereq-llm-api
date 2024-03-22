package com.whereq.llm.openai.vo.completion;

import com.whereq.llm.gpt.vo.BaseVO;
import java.util.List;

/**
 * Object containing a response chunk from the completions streaming api.
 *
 * https://platform.openai.com/docs/api-reference/completions/create
 */
public class CompletionChunk extends BaseVO {

    /**
     * A unique id assigned to this completion.
     */
    String id;

    /**https://platform.openai.com/docs/api-reference/create-completion
     * The type of object returned, should be "text_completion"
     */
    String object;

    /**
     * The creation time in epoch seconds.
     */
    long created;

    /**
     * The model used.
     */
    String model;

    /**
     * A list of generated completions.
     */
    List<CompletionChoice> choices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<CompletionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<CompletionChoice> choices) {
        this.choices = choices;
    }
}
