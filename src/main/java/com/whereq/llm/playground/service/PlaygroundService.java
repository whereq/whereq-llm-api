package com.whereq.llm.playground.service;

import com.whereq.llm.playground.vo.PlaygroundRequest;
import com.whereq.llm.playground.vo.PlaygroundResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PlaygroundService {

    public Flux<PlaygroundResponse> createStreamCompletion(PlaygroundRequest request) {
        return Flux.empty();
    }
}
