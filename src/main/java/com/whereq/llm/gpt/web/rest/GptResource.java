package com.whereq.llm.gpt.web.rest;

import com.whereq.llm.gpt.service.GptService;
import com.whereq.llm.gpt.service.MockGptService;
import com.whereq.llm.gpt.vo.GptRequest;
import com.whereq.llm.gpt.vo.GptResponse;
import com.whereq.llm.openai.mapper.CompletionRequestMapper;
import com.whereq.llm.openai.mapper.CompletionRequestMapperImpl;
import com.whereq.llm.openai.service.ChatCompletionService;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionRequest;
import java.security.Principal;
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
@RequestMapping("/api/gpt-plus")
public class GptResource {

    private final Logger log = LoggerFactory.getLogger(GptResource.class);

    private final CompletionRequestMapper completionRequestMapper = new CompletionRequestMapperImpl();

    @Autowired
    protected ChatCompletionService chatCompletionService;

    @Autowired
    private GptService gptService;

    @Autowired
    private MockGptService mockGptService;

    @PostMapping(
        path = "/chat-completion-stream",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<GptResponse> createChatCompletionResponse(@RequestBody final GptRequest gptRequest) {
        ChatCompletionRequest completionRequest = completionRequestMapper.toChatCompletionRequest(gptRequest);
        log.info("completionRequest: {}", completionRequest);
        return mockGptService.generateGptResponse(10);
    }

    @PostMapping(path = "/completion-stream", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<GptResponse> createCompletionResponse(@RequestBody final GptRequest gptRequest, Principal principal) throws Exception {
        CompletionRequest completionRequest = completionRequestMapper.toCompletionRequest(gptRequest);
        log.info("completionRequest: {}", completionRequest);
        return mockGptService.generateGptResponse(10);
    }
}
