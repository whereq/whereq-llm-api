package com.whereq.llm.openai.vo.edit;

import com.whereq.llm.openai.vo.Usage;

/**
 * An object containing the API usage for an edit request
 *
 * Deprecated, use {@link Usage} instead
 *
 * https://platform.openai.com/docs/api-reference/edits/create
 */
@Deprecated
public class EditUsage {

    /**
     * The number of prompt tokens consumed.
     */
    String promptTokens;

    /**
     * The number of completion tokens consumed.
     */
    String completionTokens;

    /**
     * The number of total tokens consumed.
     */
    String totalTokens;
}
