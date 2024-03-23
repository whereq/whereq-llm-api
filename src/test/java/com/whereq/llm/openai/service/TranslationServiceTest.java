package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.audio.TranslationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, TranslationService.class })
public class TranslationServiceTest {

    @Autowired
    private TranslationService translationService;

    @Test
    public void testGetTranslation() throws Exception {
        String model = Constants.MODEL_WHISPER_1;
        String file = "resources/openai/audio/colours-german.mp3";

        Mono<TranslationResponse> translationResponseMono = translationService.create(TranslationResponse.class, file, model);

        TranslationResponse translationResponse = translationResponseMono.block();
        System.out.println(translationResponse);
    }
}
