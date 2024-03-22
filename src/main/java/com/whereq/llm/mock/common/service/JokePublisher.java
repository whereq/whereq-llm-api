package com.whereq.llm.mock.common.service;

import com.whereq.llm.mock.common.vo.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Sinks;

@Service("jokePublisher")
public class JokePublisher {

    @Autowired
    @Qualifier("jokeWebClient")
    private WebClient jokeWebClient;

    @Autowired
    @Qualifier("jokeSink")
    private Sinks.Many<Joke> jokeSink;

    //    @Scheduled(fixedRate = 3000)
    public void publish() {
        this.jokeWebClient.get().retrieve().bodyToMono(Joke.class).subscribe(this.jokeSink::tryEmitNext);
    }
}
