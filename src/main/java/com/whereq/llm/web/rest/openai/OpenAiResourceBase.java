package com.whereq.llm.web.rest.openai;

import com.whereq.llm.openai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public abstract class OpenAiResourceBase {

    @Value("${whereq.upload.dir}")
    protected String uploadDir;

    @Autowired
    protected ChatCompletionService chatCompletionService;

    @Autowired
    protected CompletionService completionService;

    @Autowired
    protected EditService editService;

    @Autowired
    protected EmbeddingService embeddingService;

    @Autowired
    protected FileService fileService;

    @Autowired
    protected ImageService imageService;

    @Autowired
    protected ModelService modelService;

    @Autowired
    protected ModerationService moderationService;

    @Autowired
    protected TranscriptionService transcriptionService;

    @Autowired
    protected TranslationService translationService;
}
