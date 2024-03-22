package com.whereq.llm.playground.service;

import com.whereq.llm.mock.openai.PlaygroundResponseGenerator;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.playground.vo.PlaygroundResponse;
import java.time.Duration;
import java.util.UUID;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MockPlaygroundService {

    public Flux<PlaygroundResponse> generatePlaygroundResponse(int counter) {
        PlaygroundResponseGenerator.init(counter);

        String id = UUID.randomUUID().toString();
        //simulate data streaming every 1 second.
        // The Flux.interval(Duration.ofSeconds(1)) method generates a sequence of long
        // values starting from 0 at a fixed interval of one second. This long sequence is used as a time delay in the
        return Flux
            .interval(Duration.ofMillis(100))
            // The onBackpressureDrop() method is used to drop emissions from the stream if there is backpressure.
            // Backpressure can occur when the downstream consumer is not able to process the stream at the rate
            // at which it is being emitted. In this case, the onBackpressureDrop() method ensures that emissions
            // are dropped instead of buffering them, which can lead to memory issues.
            .onBackpressureDrop()
            .map(x -> PlaygroundResponseGenerator.generatePlaygroundResponse(id))
            // The flatMapIterable(x -> x) method is used to flatten the stream of CompletionResponse objects into a stream of
            // individual CompletionResponse objects. This is necessary because the CompletionResponseGenerator.generateCompletionResponse(x, id) method
            // returns a list of CompletionResponse objects for each input value, and we want to emit each of these objects individually in the stream.
            .flatMapIterable(x -> x)
            // The takeUntil operator takes a Predicate that determines when to stop the sequence.
            // like below, the sequence will stop when the first choice is "DONE".
            .takeUntil(x -> x.getResponse().equals(Constants.STREAM_DONE));
    }
}
