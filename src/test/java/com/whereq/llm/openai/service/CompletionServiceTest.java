package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import com.whereq.llm.openai.vo.completion.CompletionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, CompletionService.class })
public class CompletionServiceTest {

    @Autowired
    private CompletionService completionService;

    @Test
    public void testGetCompletion() throws Exception {
        String model = "text-davinci-003";

        CompletionRequest completionRequest = new CompletionRequest();
        completionRequest.setModel(model);
        completionRequest.setPrompt("This is a test");
        completionRequest.setMaxTokens(7);
        completionRequest.setTemperature(0.0);
        completionRequest.setTopP(1.0);
        completionRequest.setN(1);
        completionRequest.setStream(false);
        completionRequest.setLogprobs(null);
        completionRequest.setStop(Arrays.asList("\\n"));

        Mono<CompletionResponse> completionResponseMono = completionService.create(completionRequest, CompletionResponse.class);
        CompletionResponse chatCompletionResponse = completionResponseMono.block();
        System.out.println(chatCompletionResponse);
    }

    @Test
    public void testCompletionStreamService() throws Exception {
        String model = "text-davinci-003";

        String prompt = "Tell me a short story about combine blockchain with openai, limit the output within 50 words";
        CompletionRequest completionRequest = new CompletionRequest();
        completionRequest.setModel(model);
        completionRequest.setPrompt(prompt);
        completionRequest.setTemperature(0.0);
        completionRequest.setTopP(1.0);
        completionRequest.setN(1);
        completionRequest.setStream(true);
        completionRequest.setLogprobs(null);
        completionRequest.setStop(Arrays.asList("\\n"));

        Flux<CompletionResponse> completionResponseFlux = completionService.createStreamCompletion(completionRequest);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        completionResponseFlux.subscribe(
            chatCompletionResponse -> {
                System.out.println(chatCompletionResponse);
            },
            error -> {
                System.out.println("Error occurred: " + error.getMessage());
                countDownLatch.countDown();
            },
            () -> {
                System.out.println("Stream completed");
                countDownLatch.countDown();
            }
        );

        countDownLatch.await();
    }
}
