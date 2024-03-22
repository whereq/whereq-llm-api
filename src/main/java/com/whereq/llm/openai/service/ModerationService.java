package com.whereq.llm.openai.service;

import com.whereq.llm.openai.vo.moderation.ModerationRequest;
import com.whereq.llm.openai.vo.moderation.ModerationResponse;
import org.springframework.stereotype.Service;

@Service
public class ModerationService extends OpenAiService<ModerationRequest, ModerationResponse> {

    private static final String URL = "v1/moderations";

    @Override
    public String getUrl() {
        return URL;
    }
}
