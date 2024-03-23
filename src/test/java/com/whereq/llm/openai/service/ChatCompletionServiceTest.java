package com.whereq.llm.openai.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionRequest;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionResponse;
import com.whereq.llm.openai.vo.completion.chat.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WhereQConfiguration.class, ChatCompletionService.class })
public class ChatCompletionServiceTest {

    @Autowired
    private ChatCompletionService chatCompletionService;

    @Test
    public void testGetCompletion() throws Exception {
        String model = "gpt-3.5-turbo-0301";

        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest();
        chatCompletionRequest.setModel(model);

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent("make a markdown table");
        List<ChatMessage> chatMessageList = new ArrayList<>();
        chatMessageList.add(chatMessage);
        chatCompletionRequest.setMessages(chatMessageList);

        //        Mono<ChatCompletionResponse> chatCompletionResponseMono = chatCompletionService.createCompletion(chatCompletionRequest);
        Mono<ChatCompletionResponse> chatCompletionResponseMono = chatCompletionService.create(
            chatCompletionRequest,
            ChatCompletionResponse.class
        );
        ChatCompletionResponse chatCompletionResponse = chatCompletionResponseMono.block();
        System.out.println(chatCompletionResponse);
    }

    @Test
    public void testGetStreamCompletion() throws Exception {
        String model = "gpt-3.5-turbo-0301";

        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest();
        chatCompletionRequest.setModel(model);

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent("Generate two questions about two step equations");
        List<ChatMessage> chatMessageList = new ArrayList<>();
        chatMessageList.add(chatMessage);
        chatCompletionRequest.setMessages(chatMessageList);

        // Set stream to true to get the response in stream mode
        chatCompletionRequest.setStream(true);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Flux<ChatCompletionResponse> chatCompletionResponseFlux = chatCompletionService.createStream(
            chatCompletionRequest,
            ChatCompletionResponse.class
        );

        chatCompletionResponseFlux.subscribe(
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
    public void testChatCompletionStreamService() throws Exception {
        String model = "gpt-3.5-turbo-0301";

        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest();
        chatCompletionRequest.setModel(model);

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent("Generate two questions about two step equations");
        List<ChatMessage> chatMessageList = new ArrayList<>();
        chatMessageList.add(chatMessage);
        chatCompletionRequest.setMessages(chatMessageList);

        // Set stream to true to get the response in stream mode
        chatCompletionRequest.setStream(true);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Flux<ChatCompletionResponse> chatCompletionResponseFlux = chatCompletionService.createStreamCompletion(chatCompletionRequest);

        chatCompletionResponseFlux.subscribe(
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
    public void testStreamTerminator() {
        String json = Constants.STREAM_DONE;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ChatCompletionResponse chatCompletionResponse = objectMapper.readValue(json, ChatCompletionResponse.class);
            System.out.println(chatCompletionResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
