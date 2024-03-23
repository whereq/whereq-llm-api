package com.whereq.llm.mock.common.service;

import com.whereq.llm.config.MockConfiguration;
import com.whereq.llm.mock.common.vo.Joke;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MockConfiguration.class, JokeFluxTest.class })
public class JokeFluxTest {

    @Autowired
    private Flux<Joke> jokeFlux;

    @Test
    public void testJokeFlux() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        jokeFlux.subscribe(
            joke -> {
                System.out.println(joke);
                countDownLatch.countDown();
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
