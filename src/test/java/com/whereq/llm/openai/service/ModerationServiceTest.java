package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.vo.moderation.ModerationRequest;
import com.whereq.llm.openai.vo.moderation.ModerationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, ModerationService.class })
public class ModerationServiceTest {

    @Autowired
    private ModerationService moderationService;

    @Test
    public void testGetModeration() throws Exception {
        String model = "text-moderation-stable";

        ModerationRequest moderationRequest = new ModerationRequest();
        moderationRequest.setModel(model);
        moderationRequest.setInput("I want to kill them.");

        Mono<ModerationResponse> moderationResponseMono = moderationService.create(moderationRequest, ModerationResponse.class);
        ModerationResponse moderationResponse = moderationResponseMono.block();
        System.out.println(moderationResponse);
    }
}
