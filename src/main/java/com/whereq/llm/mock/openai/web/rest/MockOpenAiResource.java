package com.whereq.llm.mock.openai.web.rest;

import com.whereq.llm.mock.openai.MockOpenAiService;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import com.whereq.llm.openai.vo.completion.CompletionResponse;
import com.whereq.llm.openai.vo.completion.chat.*;
import com.whereq.llm.web.rest.openai.OpenAiResourceBase;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/openai/mock")
public class MockOpenAiResource extends OpenAiResourceBase {

    private final Logger log = LoggerFactory.getLogger(MockOpenAiResource.class);

    @Autowired
    private MockOpenAiService mockOpenAiService;

    @PostMapping(path = "/chat-completion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ChatCompletionResponse> createChatCompletionResponse(@RequestBody final ChatCompletionRequest chatCompletionRequest) {
        ChatCompletionResponse chatCompletionResponse = new ChatCompletionResponse();
        chatCompletionResponse.setModel(chatCompletionRequest.getModel());
        ChatMessage chatMessage = new ChatMessage("User", chatCompletionRequest.getMessages().get(0).getContent());
        ChatCompletionChoice chatCompletionChoice = new ChatCompletionChoice(1, chatMessage, "Done");
        chatCompletionResponse.setChoices(Arrays.asList(new ChatCompletionChoice[] { chatCompletionChoice }));
        return Mono.just(chatCompletionResponse);
    }

    @PostMapping(
        path = "/chat-completion-stream",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<StreamChatCompletionResponse> createChatCompletionStreamResponse(
        @RequestBody final ChatCompletionRequest chatCompletionRequest
    ) {
        return mockOpenAiService.generateChatCompletionResponse(10);
    }

    @PostMapping(path = "/completion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CompletionResponse> createCompletionResponse(@RequestBody final CompletionRequest completionRequest) {
        return completionService.create(completionRequest, CompletionResponse.class);
    }

    @PostMapping(path = "/completion-stream", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CompletionResponse> createCompletionStreamResponse(@RequestBody final CompletionRequest completionRequest) {
        return mockOpenAiService.generateCompletionResponse(10);
    }
}
