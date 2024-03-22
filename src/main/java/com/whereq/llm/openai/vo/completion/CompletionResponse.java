package com.whereq.llm.openai.vo.completion;

import com.whereq.llm.gpt.vo.BaseVO;
import com.whereq.llm.openai.vo.Usage;
import java.util.List;

/**
 * An object containing a response from the completion api
 *
 * https://platform.openai.com/docs/api-reference/completions/create
 */
public class CompletionResponse extends BaseVO {

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
     * The GPT model used.
     */
    String model;

    /**
     * A list of generated completions.
     */
    List<CompletionChoice> choices;

    /**
     * The API usage for this request
     */
    Usage usage;

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

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return (
            "CompletionResponse{" +
            "id='" +
            id +
            '\'' +
            ", object='" +
            object +
            '\'' +
            ", created=" +
            created +
            ", model='" +
            model +
            '\'' +
            ", choices=" +
            choices +
            ", usage=" +
            usage +
            '}'
        );
    }
}
