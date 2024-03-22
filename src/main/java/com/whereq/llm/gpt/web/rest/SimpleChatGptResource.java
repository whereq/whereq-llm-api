package com.whereq.llm.gpt.web.rest;

import com.whereq.llm.openai.service.ChatCompletionService;
import com.whereq.llm.openai.vo.SimplePromptRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/gpt")
public class SimpleChatGptResource {

    private final Logger log = LoggerFactory.getLogger(SimpleChatGptResource.class);

    @Autowired
    private ChatCompletionService chatCompletionService;

    @PostMapping(path = "/simple-chat", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> createChatCompletionResponse(@RequestBody final SimplePromptRequest simplePromptRequest) {
        return chatCompletionService.createSimpleChatCompletionResponse(simplePromptRequest.getPrompt());
    }
}
