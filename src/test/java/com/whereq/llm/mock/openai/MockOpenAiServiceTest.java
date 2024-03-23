package com.whereq.llm.mock.openai;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.vo.completion.CompletionResponse;
import com.whereq.llm.openai.vo.completion.chat.StreamChatCompletionResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WhereQConfiguration.class, MockOpenAiService.class })
public class MockOpenAiServiceTest {

    @Autowired
    private MockOpenAiService mockOpenAiService;

    @Test
    @Timeout(value = 30, unit = TimeUnit.SECONDS)
    public void testGenerateChatCompletionResponse() throws InterruptedException {
        Flux<StreamChatCompletionResponse> streamChatCompletionResponseFlux = mockOpenAiService.generateChatCompletionResponse(10);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        streamChatCompletionResponseFlux.subscribe(
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

    @Test
    @Timeout(value = 30, unit = TimeUnit.SECONDS)
    public void testGenerateCompletionResponse() throws InterruptedException {
        Flux<CompletionResponse> completionResponseFlux = mockOpenAiService.generateCompletionResponse(10);
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
