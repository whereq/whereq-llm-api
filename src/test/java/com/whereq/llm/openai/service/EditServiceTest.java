package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.vo.edit.EditRequest;
import com.whereq.llm.openai.vo.edit.EditResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, EditService.class })
public class EditServiceTest {

    @Autowired
    private EditService editService;

    @Test
    public void testGetEdit() throws Exception {
        String model = "text-davinci-edit-001";

        EditRequest editRequest = new EditRequest();
        editRequest.setModel(model);
        editRequest.setInput("What day of the wek is it?");
        editRequest.setInstruction("Fix the spelling mistake.");
        editRequest.setN(1);
        editRequest.setTemperature(1.0);
        editRequest.setTopP(1.0);

        Mono<EditResponse> editResponseMono = editService.create(editRequest, EditResponse.class);
        EditResponse editResponse = editResponseMono.block();
        System.out.println(editResponse);
    }
}
