package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.vo.embedding.EmbeddingRequest;
import com.whereq.llm.openai.vo.embedding.EmbeddingResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, EmbeddingService.class })
public class EmbeddingServiceTest {

    @Autowired
    private EmbeddingService embeddingService;

    @Test
    public void testGetEmbedding() throws Exception {
        String model = "text-embedding-ada-002";

        EmbeddingRequest editRequest = new EmbeddingRequest();
        editRequest.setModel(model);
        editRequest.setInput(Arrays.asList("The food was delicious and the waiter..."));

        Mono<EmbeddingResponse> embeddingResponseMono = embeddingService.create(editRequest, EmbeddingResponse.class);
        EmbeddingResponse embeddingResponse = embeddingResponseMono.block();
        System.out.println(embeddingResponse);
    }
}
