package com.whereq.llm.openai.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionRequest;
import com.whereq.llm.utils.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.PathResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public abstract class OpenAiService<T, S> {

    private static final Logger log = LoggerFactory.getLogger(OpenAiService.class);

    @Value("${whereq.openai.base-url}")
    protected String openAiBaseUrl;

    @Autowired
    WebClient webClient;

    public abstract String getUrl();

    public Mono<S> create(T request, Class<S> clazz) {
        return webClient
            .post()
            .uri(openAiBaseUrl + getUrl())
            .body(Mono.just(request), request.getClass())
            .exchangeToMono(clientResponse -> handleResponse(clientResponse, getUrl(), clazz));
    }

    public Flux<S> createStream(ChatCompletionRequest request, Class<S> clazz) {
        return webClient
            .post()
            .uri(openAiBaseUrl + getUrl())
            .body(Mono.just(request), request.getClass())
            .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(String.class))
            .flatMap(response -> {
                if (Constants.STREAM_DONE.equals(response)) {
                    return Flux.empty();
                } else {
                    try {
                        return Flux.just(JsonMapper.getInstance().readValue(response, clazz));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return Flux.empty();
                    }
                }
            });
    }

    public Mono<S> create(T request, ParameterizedTypeReference<S> typeReference) {
        return webClient
            .post()
            .uri(openAiBaseUrl + getUrl())
            .body(Mono.just(request), request.getClass())
            .exchangeToMono(clientResponse -> handleResponse(clientResponse, getUrl(), typeReference));
    }

    public Mono<S> create(Class<S> clazz, String file, String model) {
        var multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", new PathResource(file));
        multipartBodyBuilder.part("model", model);

        return create(clazz, multipartBodyBuilder);
    }

    public Mono<S> create(Class<S> clazz, MultipartBodyBuilder multipartBodyBuilder) {
        return webClient
            .post()
            .uri(openAiBaseUrl + getUrl())
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .bodyValue(multipartBodyBuilder.build())
            .exchangeToMono(clientResponse -> handleResponse(clientResponse, getUrl(), clazz));
    }

    String extractErrorMessage(String url, ClientResponse clientResponse) {
        String errorCode = clientResponse.statusCode().toString();
        String error = clientResponse.bodyToMono(String.class).block();
        return String.format("Error occurred while generating response from %s, error code=%s, error=%s", url, errorCode, error);
    }

    <T> Mono<T> handleResponse(ClientResponse clientResponse, String url, Class<T> clazz) {
        if (clientResponse.statusCode().is2xxSuccessful()) {
            return clientResponse.bodyToMono(clazz);
        } else {
            String errorMessage = extractErrorMessage(url, clientResponse);
            log.error("Error Message={}", errorMessage);
            return Mono.error(new Exception(errorMessage));
        }
    }

    <T> Flux<T> handleStreamResponse(ClientResponse clientResponse, String url, Class<T> clazz) {
        if (clientResponse.statusCode().is2xxSuccessful()) {
            return clientResponse.bodyToFlux(clazz);
        } else {
            String errorMessage = extractErrorMessage(url, clientResponse);
            log.error("Error Message={}", errorMessage);
            return Flux.error(new Exception(errorMessage));
        }
    }

    <T> Mono<T> handleResponse(ClientResponse clientResponse, String url, ParameterizedTypeReference<T> typeReference) {
        if (clientResponse.statusCode().is2xxSuccessful()) {
            return clientResponse.bodyToMono(typeReference);
        } else {
            String errorMessage = extractErrorMessage(url, clientResponse);
            log.error("Error Message={}", errorMessage);
            return Mono.error(new Exception(errorMessage));
        }
    }
}
