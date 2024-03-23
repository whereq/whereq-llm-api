package com.whereq.llm.openai.service;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.openai.vo.OpenAiResponse;
import com.whereq.llm.openai.vo.file.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;

@SpringBootTest
@ContextConfiguration(classes = { WhereQConfiguration.class, FileService.class })
public class FileServiceTest {

    @Autowired
    private FileService fileService;

    @Test
    public void testGetFileMono() throws Exception {
        Mono<OpenAiResponse<File>> modelOpenAiResponseMono = fileService.getFileMono();
        OpenAiResponse<File> modelOpenAiResponse = modelOpenAiResponseMono.block();
        System.out.println(modelOpenAiResponse);
    }
}
