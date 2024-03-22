package com.whereq.llm.mock.openai;

import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.completion.chat.*;
import com.whereq.llm.utils.WhereQRandom;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class StreamChatCompletionResponseGenerator {

    private static int COUNTER = 10;

    public static void init(int counter) {
        StreamChatCompletionResponseGenerator.COUNTER = counter;
    }

    public static List<StreamChatCompletionResponse> generateChatCompletionResponse(String id) {
        return Arrays.asList(StreamChatCompletionResponseGenerator.generateIndividualChatCompletionResponse(id));
    }

    public static StreamChatCompletionResponse generateIndividualChatCompletionResponse(String id) {
        StreamChatCompletionResponse streamChatCompletionResponse = new StreamChatCompletionResponse();
        streamChatCompletionResponse.setModel("mock-model");
        streamChatCompletionResponse.setId(id);
        streamChatCompletionResponse.setObject(Constants.CHAT_COMPLETION_CHUNK);
        streamChatCompletionResponse.setCreated(Instant.now().getEpochSecond());
        if (COUNTER == 0) {
            streamChatCompletionResponse.setChoices(
                Arrays.asList(
                    new StreamChatCompletionChoice[] {
                        new StreamChatCompletionChoice(0, new ChatMessage("", Constants.STREAM_DONE), "Done"),
                    }
                )
            );
        } else {
            streamChatCompletionResponse.setChoices(
                Arrays.asList(
                    new StreamChatCompletionChoice[] {
                        new StreamChatCompletionChoice(0, new ChatMessage("", WhereQRandom.randomString(1)), "Done"),
                    }
                )
            );
            COUNTER--;
        }
        return streamChatCompletionResponse;
    }
}
