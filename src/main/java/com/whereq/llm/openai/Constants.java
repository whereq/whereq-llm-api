package com.whereq.llm.openai;

public class Constants {

    // Role
    public static final String ROLE_SYSTEM = "system";
    public static final String ROLE_ASSISTANT = "assistant";
    public static final String ROLE_USER = "user";

    // Max tokens
    public static final int MAX_TOKENS_CHATGPT_35_TURBO = 2048;
    public static final int MAX_TOKENS_GPT_4 = 8192;

    // Models
    public static final String GPT_35_TURBO_0301 = "gpt-3.5-turbo-0301";
    public static final String TEXT_DAVINCI_003 = "text-davinci-003";
    public static final String MODEL_WHISPER_1 = "whisper-1";

    // OpenAI Response type
    public static final String COMPLETION = "text_completion";
    public static final String CHAT_COMPLETION = "chat.completion";

    // stream=true
    public static final String STREAM_DONE = "[DONE]";
    public static final String CHAT_COMPLETION_CHUNK = "chat.completion.chunk";
}
