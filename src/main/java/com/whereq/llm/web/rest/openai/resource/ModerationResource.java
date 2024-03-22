package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.openai.service.ModerationService;
import com.whereq.llm.openai.vo.moderation.ModerationRequest;
import com.whereq.llm.openai.vo.moderation.ModerationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class ModerationResource {

    private final Logger log = LoggerFactory.getLogger(ModerationResource.class);

    @Autowired
    private ModerationService moderationService;

    //    @PostMapping(path = "/moderation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ModerationResponse> createModerationResponse(@RequestBody final ModerationRequest editRequest) {
        return moderationService.create(editRequest, ModerationResponse.class);
    }
}
