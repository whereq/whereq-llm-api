package com.whereq.llm.mock.openai;

import com.whereq.llm.openai.Constants;
import com.whereq.llm.openai.vo.completion.CompletionChoice;
import com.whereq.llm.openai.vo.completion.CompletionResponse;
import com.whereq.llm.utils.WhereQRandom;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class CompletionResponseGenerator {

    private static int COUNTER = 10;

    public static void init(int counter) {
        CompletionResponseGenerator.COUNTER = counter;
    }

    public static List<CompletionResponse> generateCompletionResponse(String id) {
        return Arrays.asList(CompletionResponseGenerator.generateIndividualCompletionResponse(id));
    }

    // The completion response in same stream should have the same id.
    public static CompletionResponse generateIndividualCompletionResponse(String id) {
        CompletionResponse completionResponse = new CompletionResponse();
        completionResponse.setModel("mock-model");
        completionResponse.setId(id);
        completionResponse.setObject(Constants.COMPLETION);
        completionResponse.setCreated(Instant.now().getEpochSecond());
        if (COUNTER == 0) {
            completionResponse.setChoices(
                Arrays.asList(new CompletionChoice[] { new CompletionChoice(Constants.STREAM_DONE, 0, null, null) })
            );
        } else {
            completionResponse.setChoices(
                Arrays.asList(new CompletionChoice[] { new CompletionChoice(WhereQRandom.randomString(1), 0, null, null) })
            );
            COUNTER--;
        }
        return completionResponse;
    }
}
