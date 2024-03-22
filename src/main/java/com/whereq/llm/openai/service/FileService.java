package com.whereq.llm.openai.service;

import com.whereq.llm.openai.vo.OpenAiResponse;
import com.whereq.llm.openai.vo.file.File;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FileService extends OpenAiService<File, File> {

    private static final String URL = "v1/files";

    public Mono<OpenAiResponse<File>> getFileMono() {
        ParameterizedTypeReference<OpenAiResponse<File>> typeReference = new ParameterizedTypeReference<OpenAiResponse<File>>() {};
        return webClient
            .get()
            .uri(openAiBaseUrl + URL)
            .exchangeToMono(clientResponse -> handleResponse(clientResponse, URL, typeReference));
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
