package com.whereq.llm.openai.vo.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whereq.llm.gpt.vo.BaseVO;

/**
 * An object representing an event in the lifecycle of a fine-tuning job
 *
 * https://platform.openai.com/docs/api-reference/fine-tunes
 */
public class FineTuneEvent extends BaseVO {

    /**
     * The type of object returned, should be "fine-tune-event".
     */
    String object;

    /**
     * The creation time in epoch seconds.
     */
    @JsonProperty("created_at")
    Long createdAt;

    /**
     * The log level of this message.
     */
    String level;

    /**
     * The event message.
     */
    String message;
}
