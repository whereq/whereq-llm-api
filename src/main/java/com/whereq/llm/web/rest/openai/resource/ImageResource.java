package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.openai.service.ImageService;
import com.whereq.llm.openai.vo.image.CreateImageRequest;
import com.whereq.llm.openai.vo.image.ImageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class ImageResource {

    private final Logger log = LoggerFactory.getLogger(ImageResource.class);

    @Autowired
    private ImageService imageService;

    //    @PostMapping(path = "/image-generation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ImageResponse> createImageResponse(@RequestBody final CreateImageRequest editRequest) {
        return imageService.create(editRequest, ImageResponse.class);
    }
}
