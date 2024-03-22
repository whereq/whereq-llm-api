package com.whereq.llm.openai.service;

import com.whereq.llm.openai.vo.OpenAiResponse;
import com.whereq.llm.openai.vo.model.Model;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ModelService extends OpenAiService<Model, Model> {

    private static final String URL = "v1/models";

    public Mono<OpenAiResponse<Model>> getModelMono() {
        ParameterizedTypeReference<OpenAiResponse<Model>> typeReference = new ParameterizedTypeReference<OpenAiResponse<Model>>() {};
        return webClient
            .get()
            .uri(openAiBaseUrl + URL)
            .exchangeToMono(clientResponse -> handleResponse(clientResponse, URL, typeReference));
    }

    public Mono<Model> getModelMono(String modelId) {
        return webClient
            .get()
            .uri(openAiBaseUrl + URL + "/" + modelId)
            .exchangeToMono(clientResponse -> handleResponse(clientResponse, URL, Model.class));
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
