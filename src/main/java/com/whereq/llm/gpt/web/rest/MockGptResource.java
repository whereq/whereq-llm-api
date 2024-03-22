package com.whereq.llm.gpt.web.rest;

import com.whereq.llm.gpt.service.GptService;
import com.whereq.llm.gpt.vo.BaseVO;
import com.whereq.llm.gpt.vo.GptRequest;
import com.whereq.llm.gpt.vo.GptResponse;
import com.whereq.llm.openai.service.ChatCompletionService;
import com.whereq.llm.openai.vo.SimplePromptRequest;
import com.whereq.llm.utils.JsonConverter;
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
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/gpt")
public class MockGptResource {

    private final Logger log = LoggerFactory.getLogger(MockGptResource.class);

    @Autowired
    private GptService gptService;

    @Autowired
    private ChatCompletionService chatCompletionService;

    @Autowired
    private JsonConverter jsonConverter;

    @PostMapping(path = "/gpt-plus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<GptResponse> createCompletionResponse(@RequestBody final GptRequest gptRequest) {
        return gptService.createStreamCompletion(gptRequest);
    }

    @PostMapping(path = "/mock-response-string", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> createChatCompletionResponse(@RequestBody final SimplePromptRequest simplePromptRequest) {
        String response = "This is a mock response for request: " + simplePromptRequest.getPrompt();
        return Mono.just(response);
    }
}
