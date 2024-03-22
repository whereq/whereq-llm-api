package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.openai.service.FileService;
import com.whereq.llm.openai.vo.OpenAiResponse;
import com.whereq.llm.openai.vo.file.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class FileResource {

    private final Logger log = LoggerFactory.getLogger(FileResource.class);

    @Autowired
    private FileService fileService;

    //    @GetMapping(path = "/files")
    public Mono<OpenAiResponse<File>> createFileResponse() {
        return fileService.getFileMono();
    }
}
