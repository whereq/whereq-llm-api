package com.whereq.llm.openai.service;

import com.whereq.llm.openai.vo.audio.TranslationRequest;
import com.whereq.llm.openai.vo.audio.TranslationResponse;
import org.springframework.core.io.PathResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TranslationService extends OpenAiService<TranslationRequest, TranslationResponse> {

    private static final String URL = "v1/audio/translations";

    @Override
    public String getUrl() {
        return URL;
    }

    public Mono<TranslationResponse> createTranslation(TranslationRequest translationRequest) {
        var multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", new PathResource(translationRequest.getFile()));
        multipartBodyBuilder.part("model", translationRequest.getModel());

        return create(TranslationResponse.class, multipartBodyBuilder);
    }
}
