package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.vo.image.CreateImageRequest;
import com.whereq.llm.openai.vo.image.ImageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, ImageService.class })
public class ImageServiceTest {

    @Autowired
    private ImageService imageService;

    @Test
    public void testCreateImage() throws Exception {
        CreateImageRequest createImageRequest = new CreateImageRequest();
        createImageRequest.setPrompt("A cute baby red panda");
        createImageRequest.setN(1);
        createImageRequest.setSize("256x256");
        createImageRequest.setResponseFormat("url");

        Mono<ImageResponse> imageResponseMono = imageService.create(createImageRequest, ImageResponse.class);
        ImageResponse imageResponse = imageResponseMono.block();
        System.out.println(imageResponse);
    }
}
