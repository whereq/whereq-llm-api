package com.whereq.llm.openai.service;

import com.whereq.llm.openai.vo.image.CreateImageRequest;
import com.whereq.llm.openai.vo.image.ImageResponse;
import org.springframework.stereotype.Service;

@Service
public class ImageService extends OpenAiService<CreateImageRequest, ImageResponse> {

    private static final String URL = "v1/images/generations";

    @Override
    public String getUrl() {
        return URL;
    }
}
