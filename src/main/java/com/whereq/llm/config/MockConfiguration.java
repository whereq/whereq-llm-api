package com.whereq.llm.config;

import com.whereq.llm.mock.common.vo.Joke;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class MockConfiguration {

    private static final String JOKE_API_ENDPOINT = "https://joke.deno.dev/";

    @Bean(name = "testWebClientGet")
    public WebClient testWebClientGet() {
        return WebClient.builder().build();
    }

    @Bean(name = "testWebClientPost")
    public WebClient testWebClientPost() {
        return WebClient
            .builder()
            .defaultHeaders(httpHeaders -> {
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            })
            .build();
    }

    @Bean(name = "jokeWebClient")
    public WebClient jokeWebClient() {
        return WebClient.builder().baseUrl(JOKE_API_ENDPOINT).build();
    }

    @Bean(name = "jokeSink")
    public Sinks.Many<Joke> jokeSink() {
        return Sinks.many().replay().latest();
    }

    @Bean(name = "jokeFlux")
    public Flux<Joke> jokeFlux(Sinks.Many<Joke> sink) {
        return sink.asFlux().cache();
    }

    // For OpenAI mock service
    @Bean(name = "mockChatCompletionResponseSink")
    public Sinks.Many<ChatCompletionResponse> mockChatCompletionResponseSink() {
        return Sinks.many().replay().latest();
    }

    @Bean(name = "mockChatCompletionResponseFlux")
    public Flux<ChatCompletionResponse> mockChatCompletionResponseFlux(Sinks.Many<ChatCompletionResponse> sink) {
        return sink.asFlux().cache();
    }
}
