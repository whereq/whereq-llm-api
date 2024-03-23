package com.whereq.llm.openai.mapper;

import com.whereq.llm.gpt.enums.*;
import com.whereq.llm.gpt.vo.GptParameter;
import com.whereq.llm.gpt.vo.GptRequest;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompletionRequestMapperTest {

    private CompletionRequestMapper completionRequestMapper;

    @BeforeEach
    public void setUp() {
        completionRequestMapper = new CompletionRequestMapperImpl();
    }

    @Test
    public void testToCompletionRequest() throws Exception {
        GptParameter gptParameter = new GptParameter();
        gptParameter.setTask("task");
        gptParameter.setTopic("topic");
        gptParameter.setStyle(StyleEnum.Academic);
        gptParameter.setTone(ToneEnum.Analytical);
        gptParameter.setAudience(AudienceEnum.All);
        gptParameter.setLength(LengthEnum.LENGTH_20_WORDS);
        gptParameter.setFormat(FormatEnum.Text);

        GptRequest gptRequest = new GptRequest();
        gptRequest.setPrompt("prompt");
        gptRequest.setGptParameter(gptParameter);

        CompletionRequest completionRequest = completionRequestMapper.toCompletionRequest(gptRequest);
        System.out.println(completionRequest);
    }
}
