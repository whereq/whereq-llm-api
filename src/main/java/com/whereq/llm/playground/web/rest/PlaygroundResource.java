package com.whereq.llm.playground.web.rest;

import com.whereq.llm.openai.mapper.CompletionRequestMapper;
import com.whereq.llm.openai.mapper.CompletionRequestMapperImpl;
import com.whereq.llm.playground.service.MockPlaygroundService;
import com.whereq.llm.playground.service.PlaygroundService;
import com.whereq.llm.playground.vo.PlaygroundRequest;
import com.whereq.llm.playground.vo.PlaygroundResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/playground")
public class PlaygroundResource {

    private final Logger log = LoggerFactory.getLogger(PlaygroundResource.class);

    private final CompletionRequestMapper completionRequestMapper = new CompletionRequestMapperImpl();

    @Autowired
    private PlaygroundService playgroundService;

    @Autowired
    private MockPlaygroundService mockPlaygroundService;

    @PostMapping(
        path = "/chat-completion-stream",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<PlaygroundResponse> createChatCompletionResponse(@RequestBody final PlaygroundRequest playgroundRequest) {
        return mockPlaygroundService.generatePlaygroundResponse(10);
    }

    @PostMapping(path = "/completion-stream", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PlaygroundResponse> createCompletionResponse(@RequestBody final PlaygroundRequest playgroundRequest) {
        return mockPlaygroundService.generatePlaygroundResponse(10);
    }
}
