package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.openai.service.ModelService;
import com.whereq.llm.openai.vo.OpenAiResponse;
import com.whereq.llm.openai.vo.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class ModelResource {

    private final Logger log = LoggerFactory.getLogger(ModelResource.class);

    @Autowired
    private ModelService modelService;

    //    @GetMapping(path = "/models")
    public Mono<OpenAiResponse<Model>> getModels() {
        return modelService.getModelMono();
    }

    //    @GetMapping(path = "/models/{id}")
    public Mono<Model> getModel(@PathVariable("id") final String id) {
        return modelService.getModelMono(id);
    }
}
