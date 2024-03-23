package com.whereq.llm.mock.web.rest;

import com.whereq.llm.config.MockConfiguration;
import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.mock.common.vo.Comment;
import com.whereq.llm.mock.common.vo.Joke;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import com.whereq.llm.openai.vo.completion.CompletionResponse;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionRequest;
import com.whereq.llm.openai.vo.completion.chat.StreamChatCompletionResponse;
import com.whereq.llm.web.rest.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WhereQConfiguration.class, MockConfiguration.class, MockResourceTest.class })
public class MockResourceTest {

    @Autowired
    @Qualifier("testWebClientGet")
    private WebClient mockWebClientGet;

    @Autowired
    @Qualifier("testWebClientPost")
    private WebClient mockWebClientPost;

    @Test
    @Timeout(value = 30, unit = TimeUnit.SECONDS)
    public void testChatCompletionStream() throws InterruptedException, IOException {
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest();
        Flux<StreamChatCompletionResponse> streamChatCompletionResponseFlux = mockWebClientPost
            .post()
            .uri("http://localhost:8080/api/openai/mock/chat-completion-stream")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(chatCompletionRequest))
            .accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE))
            .exchangeToFlux(response -> response.bodyToFlux(StreamChatCompletionResponse.class));

        CountDownLatch countDownLatch = new CountDownLatch(1);
        streamChatCompletionResponseFlux.subscribe(
            comment -> {
                System.out.println(comment);
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
    public void testCompletionStream() throws InterruptedException, IOException {
        CompletionRequest completionRequest = new CompletionRequest();
        Flux<CompletionResponse> completionResponseFlux = mockWebClientPost
            .post()
            .uri("http://localhost:8080/api/openai/mock/completion-stream")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(completionRequest))
            .accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE))
            .exchangeToFlux(response -> response.bodyToFlux(CompletionResponse.class));

        CountDownLatch countDownLatch = new CountDownLatch(1);
        completionResponseFlux.subscribe(
            comment -> {
                System.out.println(comment);
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
    public void testCommentStream() throws InterruptedException {
        Flux<Comment> comments = mockWebClientGet
            .get()
            .uri("http://localhost:8080/api/mock/comment/stream")
            .accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE))
            .exchangeToFlux(response -> response.bodyToFlux(Comment.class));

        CountDownLatch countDownLatch = new CountDownLatch(1);
        comments.subscribe(
            comment -> {
                System.out.println(comment);
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
    public void testJokeStream() throws InterruptedException {
        Flux<Joke> jokeFlux = mockWebClientGet
            .get()
            .uri("http://localhost:8080/api/mock/joke/stream")
            .accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE))
            .exchangeToFlux(response -> response.bodyToFlux(Joke.class));

        CountDownLatch countDownLatch = new CountDownLatch(1);
        jokeFlux.subscribe(
            joke -> {
                System.out.println(joke);
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
