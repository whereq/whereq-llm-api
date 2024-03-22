package com.whereq.llm.openai.vo.moderation;

import com.whereq.llm.gpt.vo.BaseVO;

/**
 * A request for OpenAi to detect if text violates OpenAi's content policy.
 *
 * https://platform.openai.com/docs/api-reference/moderations/create
 */
public class ModerationRequest extends BaseVO {

    /**
     * The input text to classify.
     */
    //    @NonNull
    String input;

    /**
     * The name of the model to use, defaults to text-moderation-stable.
     */
    String model;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "ModerationRequest{" + "input='" + input + '\'' + ", model='" + model + '\'' + '}';
    }
}
