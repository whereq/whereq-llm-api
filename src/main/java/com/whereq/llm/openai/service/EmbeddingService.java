package com.whereq.llm.openai.service;

import com.whereq.llm.openai.vo.embedding.EmbeddingRequest;
import com.whereq.llm.openai.vo.embedding.EmbeddingResponse;
import org.springframework.stereotype.Service;

@Service
public class EmbeddingService extends OpenAiService<EmbeddingRequest, EmbeddingResponse> {

    private static final String URL = "v1/embeddings";

    @Override
    public String getUrl() {
        return URL;
    }
}
