package com.whereq.llm.openai.service;

import com.whereq.llm.openai.vo.audio.TranscriptionRequest;
import com.whereq.llm.openai.vo.audio.TranscriptionResponse;
import org.springframework.core.io.PathResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TranscriptionService extends OpenAiService<TranscriptionRequest, TranscriptionResponse> {

    private static final String URL = "v1/audio/transcriptions";

    @Override
    public String getUrl() {
        return URL;
    }

    public Mono<TranscriptionResponse> createTranscription(TranscriptionRequest transcriptionRequest) {
        var multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", new PathResource(transcriptionRequest.getFile()));
        multipartBodyBuilder.part("model", transcriptionRequest.getModel());

        return create(TranscriptionResponse.class, multipartBodyBuilder);
    }
}
