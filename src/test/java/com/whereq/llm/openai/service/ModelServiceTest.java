package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.vo.OpenAiResponse;
import com.whereq.llm.openai.vo.model.Model;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, ModelService.class })
public class ModelServiceTest {

    @Autowired
    private ModelService modelService;

    @Test
    public void testGetModelMono() throws Exception {
        Mono<OpenAiResponse<Model>> modelOpenAiResponseMono = modelService.getModelMono();
        OpenAiResponse<Model> modelOpenAiResponse = modelOpenAiResponseMono.block();
        System.out.println(modelOpenAiResponse);
    }

    @Test
    public void testGetModelByIdMono() throws Exception {
        String modelId = "text-ada-001";
        Mono<Model> modelMono = modelService.getModelMono(modelId);
        Model model = modelMono.block();
        System.out.println(model);
    }
}
