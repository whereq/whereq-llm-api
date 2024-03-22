package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.openai.service.EditService;
import com.whereq.llm.openai.vo.edit.EditRequest;
import com.whereq.llm.openai.vo.edit.EditResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class EditResource {

    private final Logger log = LoggerFactory.getLogger(EditResource.class);

    @Autowired
    private EditService editService;

    //    @PostMapping(path = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EditResponse> createEditResponse(@RequestBody final EditRequest editRequest) {
        return editService.create(editRequest, EditResponse.class);
    }
}
