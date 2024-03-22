package com.whereq.llm.gpt.service;

import com.whereq.llm.gpt.vo.GptRequest;
import com.whereq.llm.gpt.vo.GptResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GptService {

    public Flux<GptResponse> createStreamCompletion(GptRequest request) {
        return Flux.empty();
    }
}
