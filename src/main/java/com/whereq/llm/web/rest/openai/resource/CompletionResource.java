package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.openai.service.CompletionService;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import com.whereq.llm.openai.vo.completion.CompletionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class CompletionResource {

    private final Logger log = LoggerFactory.getLogger(CompletionResource.class);

    @Autowired
    private CompletionService completionService;

    //    @PostMapping(path = "/completion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CompletionResponse> createCompletionResponse(@RequestBody final CompletionRequest completionRequest) {
        return completionService.create(completionRequest, CompletionResponse.class);
    }
}
