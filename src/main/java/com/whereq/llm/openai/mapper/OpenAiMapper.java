package com.whereq.llm.openai.mapper;

import com.whereq.llm.gpt.vo.GptRequest;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import org.springframework.stereotype.Service;

@Service
public class OpenAiMapper {

    public CompletionRequest toCompletionRequest(GptRequest gptRequest) {
        CompletionRequestMapper completionRequestMapper = new CompletionRequestMapperImpl();
        return completionRequestMapper.toCompletionRequest(gptRequest);
    }
}
