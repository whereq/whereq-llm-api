package com.whereq.llm.gpt.utils;

import com.whereq.llm.gpt.vo.GptParameter;
import com.whereq.llm.gpt.vo.GptRequest;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import java.util.Arrays;

/**
 * Builder class for building GPT request.
 *
 * TODO: consider to have the building logic to be in the particular GPT provider class later!!!
 */
public class RequestBuilder {

    public static CompletionRequest buildOpenAiCompletionRequest(GptRequest gptRequest) {
        GptParameter gptParameter = gptRequest.getGptParameter();
        if (gptParameter == null) {
            gptParameter = new GptParameter();
        }

        CompletionRequest completionRequest = new CompletionRequest();
        completionRequest.setModel(Constants.TEXT_DAVINCI_003);
        completionRequest.setPrompt(gptRequest.getPrompt());

        completionRequest.setMaxTokens(100);
        completionRequest.setTemperature(0.7);
        completionRequest.setTopP(1.0);
        completionRequest.setFrequencyPenalty(0.0);
        completionRequest.setPresencePenalty(0.0);
        completionRequest.setStop(Arrays.asList("\\n"));
        return completionRequest;
    }
}
