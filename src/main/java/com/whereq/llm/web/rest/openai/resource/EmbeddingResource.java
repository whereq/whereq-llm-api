package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.openai.service.EmbeddingService;
import com.whereq.llm.openai.vo.embedding.EmbeddingRequest;
import com.whereq.llm.openai.vo.embedding.EmbeddingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class EmbeddingResource {

    private final Logger log = LoggerFactory.getLogger(EmbeddingResource.class);

    @Autowired
    private EmbeddingService embeddingService;

    //    @PostMapping(path = "/embedding", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EmbeddingResponse> createEmbeddingResponse(@RequestBody final EmbeddingRequest embeddingRequest) {
        return embeddingService.create(embeddingRequest, EmbeddingResponse.class);
    }
}
