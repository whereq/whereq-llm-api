package com.whereq.llm.openai.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionChoice;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionRequest;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionResponse;
import com.whereq.llm.openai.vo.completion.chat.ChatMessage;
import com.whereq.llm.utils.JsonMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ChatCompletionService extends OpenAiService<ChatCompletionRequest, ChatCompletionResponse> {

    private static final String URL = "v1/chat/completions";

    @Override
    public String getUrl() {
        return URL;
    }

    public Mono<String> createSimpleChatCompletionResponse(final String prompt) {
        String model = "gpt-3.5-turbo-0301";

        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest();
        chatCompletionRequest.setModel(model);

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent(prompt);
        List<ChatMessage> chatMessageList = new ArrayList<>();
        chatMessageList.add(chatMessage);
        chatCompletionRequest.setMessages(chatMessageList);

        return create(chatCompletionRequest, ChatCompletionResponse.class)
            .map(chatCompletionResponse -> chatCompletionResponse.getChoices().get(0).getMessage().getContent());
    }

    public Flux<ChatCompletionResponse> createStreamCompletion(ChatCompletionRequest request) {
        String model = "gpt-3.5-turbo-0301";

        request.setModel(model);
        return webClient
            .post()
            .uri(openAiBaseUrl + getUrl())
            .body(Mono.just(request), request.getClass())
            .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(String.class))
            .flatMap(response -> {
                if (Constants.STREAM_DONE.equals(response)) {
                    ChatCompletionResponse chatCompletionResponse = new ChatCompletionResponse();
                    chatCompletionResponse.setChoices(
                        Arrays.asList(
                            new ChatCompletionChoice[] { new ChatCompletionChoice(0, new ChatMessage(null, null), Constants.STREAM_DONE) }
                        )
                    );
                    return Flux.just(chatCompletionResponse);
                } else {
                    try {
                        return Flux.just(JsonMapper.getInstance().readValue(response, ChatCompletionResponse.class));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return Flux.empty();
                    }
                }
            });
    }
}
