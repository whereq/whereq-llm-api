package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.openai.service.ChatCompletionService;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionRequest;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class ChatCompletionResource {

    private final Logger log = LoggerFactory.getLogger(ChatCompletionResource.class);

    @Autowired
    private ChatCompletionService chatCompletionService;

    //    @PostMapping(path = "/chat-completion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ChatCompletionResponse> createChatCompletionResponse(@RequestBody final ChatCompletionRequest chatCompletionRequest) {
        return chatCompletionService.create(chatCompletionRequest, ChatCompletionResponse.class);
    }
}
