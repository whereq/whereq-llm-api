package com.whereq.llm.openai.service;

import com.whereq.llm.openai.vo.edit.EditRequest;
import com.whereq.llm.openai.vo.edit.EditResponse;
import org.springframework.stereotype.Service;

@Service
public class EditService extends OpenAiService<EditRequest, EditResponse> {

    private static final String URL = "v1/edits";

    @Override
    public String getUrl() {
        return URL;
    }
}
