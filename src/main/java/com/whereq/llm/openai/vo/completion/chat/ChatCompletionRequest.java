package com.whereq.llm.openai.vo.completion.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whereq.llm.gpt.vo.BaseVO;
import java.util.List;
import java.util.Map;

public class ChatCompletionRequest extends BaseVO {

    /**
     * ID of the model to use.
     */
    String model;

    /**
     * The messages to generate chat completions for, in the <a
     * href="https://platform.openai.com/docs/guides/chat/introduction">chat format</a>.<br>
     * see {@link ChatMessage}
     */
    List<ChatMessage> messages;

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random, while lower
     * values like 0.2 will make it more focused and deterministic.<br>
     * We generally recommend altering this or top_p but not both.
     */
    Double temperature = 1.0;

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens
     * with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.<br>
     * We generally recommend altering this or temperature but not both.
     */
    @JsonProperty("top_p")
    Double topP = 1.0;

    /**
     * How many chat completion chatCompletionChoices to generate for each input message.
     */
    Integer n;

    /**
     * If set, partial message deltas will be sent, like in ChatGPT. Tokens will be sent as data-only <a
     * href="https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events/Using_server-sent_events#Event_stream_format">server-sent
     * events</a> as they become available, with the stream terminated by a data: [DONE] message.
     */
    Boolean stream = false;

    /**
     * Up to 4 sequences where the API will stop generating further tokens.
     */
    List<String> stop;

    /**
     * The maximum number of tokens allowed for the generated answer. By default, the number of tokens the model can return will
     * be (4096 - prompt tokens).
     */
    @JsonProperty("max_tokens")
    Integer maxTokens;

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they appear in the text so far,
     * increasing the model's likelihood to talk about new topics.
     */
    @JsonProperty("presence_penalty")
    Double presencePenalty = 0.0;

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing frequency in the text so far,
     * decreasing the model's likelihood to repeat the same line verbatim.
     */
    @JsonProperty("frequency_penalty")
    Double frequencyPenalty = 0.0;

    /**
     * Accepts a json object that maps tokens (specified by their token ID in the tokenizer) to an associated bias value from -100
     * to 100. Mathematically, the bias is added to the logits generated by the model prior to sampling. The exact effect will
     * vary per model, but values between -1 and 1 should decrease or increase likelihood of selection; values like -100 or 100
     * should result in a ban or exclusive selection of the relevant token.
     */
    @JsonProperty("logit_bias")
    Map<String, Integer> logitBias = null;

    /**
     * A unique identifier representing your end-user, which will help OpenAI to monitor and detect abuse.
     */
    //    @JsonIgnore
    String user = null;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTopP() {
        return topP;
    }

    public void setTopP(Double topP) {
        this.topP = topP;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public List<String> getStop() {
        return stop;
    }

    public void setStop(List<String> stop) {
        this.stop = stop;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Double getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(Double presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    public Double getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(Double frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public Map<String, Integer> getLogitBias() {
        return logitBias;
    }

    public void setLogitBias(Map<String, Integer> logitBias) {
        this.logitBias = logitBias;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return (
            "ChatCompletionRequest{" +
            "model='" +
            model +
            '\'' +
            ", messages=" +
            messages +
            ", temperature=" +
            temperature +
            ", topP=" +
            topP +
            ", n=" +
            n +
            ", stream=" +
            stream +
            ", stop=" +
            stop +
            ", maxTokens=" +
            maxTokens +
            ", presencePenalty=" +
            presencePenalty +
            ", frequencyPenalty=" +
            frequencyPenalty +
            ", logitBias=" +
            logitBias +
            ", user='" +
            user +
            '\'' +
            '}'
        );
    }
}
