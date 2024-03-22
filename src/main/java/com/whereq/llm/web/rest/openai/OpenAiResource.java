package com.whereq.llm.web.rest.openai;

import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.OpenAiResponse;
import com.whereq.llm.openai.vo.audio.TranscriptionResponse;
import com.whereq.llm.openai.vo.audio.TranslationResponse;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import com.whereq.llm.openai.vo.completion.CompletionResponse;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionRequest;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionResponse;
import com.whereq.llm.openai.vo.edit.EditRequest;
import com.whereq.llm.openai.vo.edit.EditResponse;
import com.whereq.llm.openai.vo.embedding.EmbeddingRequest;
import com.whereq.llm.openai.vo.embedding.EmbeddingResponse;
import com.whereq.llm.openai.vo.model.Model;
import com.whereq.llm.openai.vo.moderation.ModerationRequest;
import com.whereq.llm.openai.vo.moderation.ModerationResponse;
import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/openai")
public class OpenAiResource extends OpenAiResourceBase {

    private final Logger log = LoggerFactory.getLogger(OpenAiResource.class);

    @PostMapping(path = "/chat-completion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ChatCompletionResponse> createChatCompletionResponse(@RequestBody final ChatCompletionRequest chatCompletionRequest) {
        return chatCompletionService.create(chatCompletionRequest, ChatCompletionResponse.class);
    }

    @PostMapping(
        path = "/chat-completion-stream",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<ChatCompletionResponse> createChatCompletionStreamResponse(@RequestBody final ChatCompletionRequest chatCompletionRequest) {
        return chatCompletionService.createStreamCompletion(chatCompletionRequest);
    }

    @PostMapping(path = "/completion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CompletionResponse> createCompletionResponse(@RequestBody final CompletionRequest completionRequest) {
        return completionService.create(completionRequest, CompletionResponse.class);
    }

    @PostMapping(path = "/completion-stream", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<CompletionResponse> createCompletionStreamResponse(@RequestBody final CompletionRequest completionRequest) {
        return completionService.createStreamCompletion(completionRequest);
    }

    @PostMapping(path = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EditResponse> createEditResponse(@RequestBody final EditRequest editRequest) {
        return editService.create(editRequest, EditResponse.class);
    }

    @PostMapping(path = "/embedding", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EmbeddingResponse> createEmbeddingResponse(@RequestBody final EmbeddingRequest embeddingRequest) {
        return embeddingService.create(embeddingRequest, EmbeddingResponse.class);
    }

    @GetMapping(path = "/models")
    public Mono<OpenAiResponse<Model>> getModels() {
        return modelService.getModelMono();
    }

    @GetMapping(path = "/models/{id}")
    public Mono<Model> getModel(@PathVariable("id") final String id) {
        return modelService.getModelMono(id);
    }

    @PostMapping(path = "/moderation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ModerationResponse> createModerationResponse(@RequestBody final ModerationRequest editRequest) {
        return moderationService.create(editRequest, ModerationResponse.class);
    }

    @PostMapping(path = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping(path = "/translation", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TranslationResponse> createTranslationResponse(
        @RequestPart("file") final FilePart audio,
        @RequestPart(value = "model", required = false) String model
    ) {
        if (StringUtils.isBlank(model)) {
            model = Constants.MODEL_WHISPER_1;
        }
        String originalFilename = audio.filename();
        File dest = new File(uploadDir + originalFilename); // Set your desired file path here
        Mono<Void> voidMono = audio.transferTo(dest); // Save the uploaded file to the specified path
        return voidMono.then(translationService.create(TranslationResponse.class, dest.getAbsolutePath(), model));
    }
}
