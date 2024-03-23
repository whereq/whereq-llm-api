package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.audio.TranscriptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, TranscriptionService.class })
public class TranscriptionServiceTest {

    @Autowired
    private TranscriptionService transcriptionService;

    @Test
    public void testGetTranscription() throws Exception {
        String model = Constants.MODEL_WHISPER_1;
        String file = "C:\\Users\\googo\\whereq\\git\\whereq.com\\resources\\openai\\audio\\the_sun_is_up.mp3";

        Mono<TranscriptionResponse> transcriptionResponseMono = transcriptionService.create(TranscriptionResponse.class, file, model);
        TranscriptionResponse transcriptionResponse = transcriptionResponseMono.block();
        System.out.println(transcriptionResponse);
    }
}
