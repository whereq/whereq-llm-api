package com.whereq.llm.openai.vo.completion.chat;

import com.whereq.llm.gpt.vo.BaseVO;
import com.whereq.llm.openai.vo.Usage;
import java.util.List;

/**
 * Object containing a response from the chat completions api.
 */
public class StreamChatCompletionResponse extends BaseVO {

    /**
     * Unique id assigned to this chat completion.
     */
    String id;

    /**
     * The type of object returned, should be "chat.completion"
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
     * A list of all generated completions.
     */
    List<StreamChatCompletionChoice> choices;

    /**
     * The API usage for this request.
     */
    Usage usage;

    public StreamChatCompletionResponse() {}

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

    public List<StreamChatCompletionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<StreamChatCompletionChoice> choices) {
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
            "ChatCompletionResponse{" +
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
