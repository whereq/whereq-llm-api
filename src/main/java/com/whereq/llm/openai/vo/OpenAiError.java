package com.whereq.llm.openai.vo;

/**
 * Represents the error body when an OpenAI request fails
 */
public class OpenAiError {

    public OpenAiErrorDetails error;

    public static class OpenAiErrorDetails {

        /**
         * Human-readable error message
         */
        String message;

        /**
         * OpenAI error type, for example "invalid_request_error"
         * https://platform.openai.com/docs/guides/error-codes/python-library-error-types
         */
        String type;

        String param;

        /**
         * OpenAI error code, for example "invalid_api_key"
         */
        String code;
    }
}
