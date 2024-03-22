package com.whereq.llm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Properties specific to Whereq.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link tech.jhipster.config.JHipsterProperties} for a good example.
 */
@Configuration
//@ConfigurationProperties(prefix = "whereq", ignoreUnknownFields = false)
public class WhereQConfiguration {

    @Value("${whereq.upload.dir}")
    private String uploadDir;

    @Value("${whereq.openai.api-key:''}")
    private String openaiApiKey;

    @Value("${whereq.openai.base-url:https://api.openai.com/}")
    private String openaiBaseUrl;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public String getOpenaiApiKey() {
        return openaiApiKey;
    }

    public void setOpenaiApiKey(String openaiApiKey) {
        this.openaiApiKey = openaiApiKey;
    }

    public String getOpenaiBaseUrl() {
        return openaiBaseUrl;
    }

    public String setOpenaiBaseUrl(String openaiBaseUrl) {
        return this.openaiBaseUrl = openaiBaseUrl;
    }

    @Bean
    WebClient webClient() {
        return WebClient
            .builder()
            .defaultHeaders(httpHeaders -> {
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                httpHeaders.setBearerAuth(openaiApiKey);
            })
            .baseUrl(openaiBaseUrl)
            .build();
    }
}
