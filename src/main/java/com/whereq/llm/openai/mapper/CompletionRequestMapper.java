package com.whereq.llm.openai.mapper;

import com.whereq.llm.gpt.enums.LengthEnum;
import com.whereq.llm.gpt.enums.StyleEnum;
import com.whereq.llm.gpt.enums.ToneEnum;
import com.whereq.llm.gpt.vo.GptRequest;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.completion.CompletionRequest;
import com.whereq.llm.openai.vo.completion.chat.ChatCompletionRequest;
import com.whereq.llm.openai.vo.completion.chat.ChatMessage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CompletionRequestMapper {
    @Mapping(target = "model", constant = Constants.GPT_35_TURBO_0301)
    @Mapping(target = "maxTokens", source = "gptParameter.length")
    @Mapping(
        target = "temperature",
        expression = "java(mapTemperature(gptRequest.getGptParameter().getStyle(), gptRequest.getGptParameter().getTone()))"
    )
    @Mapping(target = "stream", constant = "true")
    @Mapping(target = "messages", source = "gptRequest.prompt", qualifiedByName = "mapChatMessages")
    ChatCompletionRequest toChatCompletionRequest(GptRequest gptRequest);

    @Mapping(target = "prompt", source = "prompt")
    @Mapping(target = "model", constant = Constants.TEXT_DAVINCI_003)
    @Mapping(target = "maxTokens", source = "gptParameter.length")
    @Mapping(
        target = "temperature",
        expression = "java(mapTemperature(gptRequest.getGptParameter().getStyle(), gptRequest.getGptParameter().getTone()))"
    )
    @Mapping(target = "stream", constant = "true")
    CompletionRequest toCompletionRequest(GptRequest gptRequest);

    default int lengthEnumToMaxTokens(LengthEnum lengthEnum) {
        switch (lengthEnum) {
            case LENGTH_DEFAULT:
                return 37;
            case LENGTH_MAX:
                return Constants.MAX_TOKENS_CHATGPT_35_TURBO;
            case LENGTH_1_PARAGRAPH:
                return 43;
            case LENGTH_2_PARAGRAPH:
                return 89;
            case LENGTH_3_PARAGRAPH:
                return 133;
            case LENGTH_20_WORDS:
                return 20;
            case LENGTH_50_WORDS:
                return 50;
            case LENGTH_100_WORDS:
                return 100;
            case LENGTH_200_WORDS:
                return 200;
            case LENGTH_500_WORDS:
                return 500;
        }
        return 37;
    }

    default Double mapTemperature(StyleEnum style, ToneEnum tone) {
        return style.getValue() * tone.getValue();
    }

    @Named("mapChatMessages")
    default List<ChatMessage> mapChatMessages(String prompt) {
        return Stream.of(new ChatMessage(Constants.ROLE_USER, prompt)).collect(Collectors.toList());
    }
}
