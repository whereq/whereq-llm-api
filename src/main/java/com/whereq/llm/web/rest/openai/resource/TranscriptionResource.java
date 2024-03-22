package com.whereq.llm.web.rest.openai.resource;

import com.whereq.llm.config.Constants;
import com.whereq.llm.openai.service.TranscriptionService;
import com.whereq.llm.openai.vo.audio.TranscriptionResponse;
import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.RequestPart;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/api/openai")
public class TranscriptionResource {

    private final Logger log = LoggerFactory.getLogger(TranscriptionResource.class);

    @Value("${whereq.upload.dir}")
    protected String uploadDir;

    @Autowired
    private TranscriptionService transcriptionService;

    //    @PostMapping(path = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TranscriptionResponse> createTranscriptionResponse(
        @RequestPart("file") final FilePart audio,
        @RequestPart(value = "model", required = false) String model
    ) {
        if (StringUtils.isBlank(model)) {
            model = Constants.MODEL_WHISPER_1;
        }
        String originalFilename = audio.filename();
        File dest = new File(uploadDir + originalFilename); // Set your desired file path here
        Mono<Void> voidMono = audio.transferTo(dest); // Save the uploaded file to the specified path
        return voidMono.then(transcriptionService.create(TranscriptionResponse.class, dest.getAbsolutePath(), model));
    }
}
