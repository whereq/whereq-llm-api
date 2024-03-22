package com.whereq.llm.openai.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.completion.CompletionChoice;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import com.whereq.llm.openai.vo.completion.CompletionResponse;
import com.whereq.llm.utils.JsonMapper;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompletionService extends OpenAiService<CompletionRequest, CompletionResponse> {

    private static final String URL = "v1/completions";

    @Override
    public String getUrl() {
        return URL;
    }

    public Flux<CompletionResponse> createStreamCompletion(CompletionRequest request) {
        return webClient
            .post()
            .uri(openAiBaseUrl + getUrl())
            .body(Mono.just(request), request.getClass())
            .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(String.class))
            .flatMap(response -> {
                if (Constants.STREAM_DONE.equals(response)) {
                    CompletionResponse chatCompletionResponse = new CompletionResponse();
                    chatCompletionResponse.setChoices(
                        Arrays.asList(new CompletionChoice[] { new CompletionChoice(Constants.STREAM_DONE, null, null, null) })
                    );
                    return Flux.just(chatCompletionResponse);
                } else {
                    try {
                        return Flux.just(JsonMapper.getInstance().readValue(response, CompletionResponse.class));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return Flux.empty();
                    }
                }
            });
    }
}
