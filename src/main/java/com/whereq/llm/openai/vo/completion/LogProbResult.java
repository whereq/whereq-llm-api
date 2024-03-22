package com.whereq.llm.openai.vo.completion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whereq.llm.gpt.vo.BaseVO;
import java.util.List;
import java.util.Map;

/**
 * Log probabilities of different token options
 * Returned if {@link CompletionRequest#logprobs} is greater than zero
 *
 * https://platform.openai.com/docs/api-reference/create-completion
 */
public class LogProbResult extends BaseVO {

    /**
     * The tokens chosen by the completion api
     */
    List<String> tokens;

    /**
     * The log probability of each token in {@link tokens}
     */
    @JsonProperty("token_logprobs")
    List<Double> tokenLogprobs;

    /**
     * A map for each index in the completion result.
     * The map contains the top {@link CompletionRequest#logprobs} tokens and their probabilities
     */
    @JsonProperty("top_logprobs")
    List<Map<String, Double>> topLogprobs;

    /**
     * The character offset from the start of the returned text for each of the chosen tokens.
     */
    List<Integer> textOffset;

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public List<Double> getTokenLogprobs() {
        return tokenLogprobs;
    }

    public void setTokenLogprobs(List<Double> tokenLogprobs) {
        this.tokenLogprobs = tokenLogprobs;
    }

    public List<Map<String, Double>> getTopLogprobs() {
        return topLogprobs;
    }

    public void setTopLogprobs(List<Map<String, Double>> topLogprobs) {
        this.topLogprobs = topLogprobs;
    }

    public List<Integer> getTextOffset() {
        return textOffset;
    }

    public void setTextOffset(List<Integer> textOffset) {
        this.textOffset = textOffset;
    }
}
