package com.whereq.llm.mock.openai;

import com.whereq.llm.gpt.vo.GptResponse;
import com.whereq.llm.gpt.vo.Usage;
import com.whereq.llm.openai.Constants;
import com.whereq.llm.utils.WhereQRandom;
import java.util.Arrays;
import java.util.List;

public class GptResponseGenerator {

    private static final String WhereQ_GPT_Plus =
        "WhereQ GPT Plus is a middleware solution aimed at simplifying and enhancing user experiences with GPT services. By providing unique interfaces, it eases the integration process for developers who wish to incorporate GPT models into their applications. Acting as a middle layer, WhereQ GPT Plus abstracts complexities and offers a standardized approach, making GPT integration more accessible.\n" +
        "\n" +
        "With WhereQ GPT Plus, user experiences receive a significant boost. The middleware offers intuitive interfaces that allow seamless interaction with GPT services. Developers can leverage advanced language processing capabilities, such as text generation, translation, and sentiment analysis, to create applications with powerful language understanding features. WhereQ GPT Plus ensures a user-friendly experience that enhances overall usability.\n" +
        "\n" +
        "Flexibility and customization are key aspects of WhereQ GPT Plus. Developers can tailor the middleware to fit specific application requirements, adjusting the behavior and responses of integrated GPT models. This flexibility empowers developers to deliver unique user experiences and optimize GPT service output according to the application's domain and context. WhereQ GPT Plus provides the necessary adaptability for building tailored solutions.\n" +
        "\n" +
        "In conclusion, WhereQ GPT Plus simplifies GPT integration, improves user experiences, and offers customization options. With its streamlined interfaces, developers can seamlessly incorporate GPT capabilities into their applications. By leveraging WhereQ GPT Plus, developers can create user-friendly applications with advanced language processing features, delivering enhanced experiences to their users. The flexibility and adaptability of WhereQ GPT Plus enable developers to tailor solutions according to their specific needs, optimizing GPT services for their applications.";

    private static final int LENGTH = WhereQ_GPT_Plus.length();

    private static int INDEX = 0;

    private static int COUNTER = 10;

    public static void init(int counter) {
        GptResponseGenerator.INDEX = 0;
        GptResponseGenerator.COUNTER = counter;
    }

    public static List<GptResponse> generateGptResponse(String id) {
        //        return Arrays.asList(GptResponseGenerator.generateIndividualCompletionResponse(id));
        return Arrays.asList(GptResponseGenerator.generateCompletionResponse(id));
    }

    // The completion response in same stream should have the same id.
    public static GptResponse generateIndividualCompletionResponse(String id) {
        GptResponse gptResponse = new GptResponse();
        if (COUNTER == 0) {
            gptResponse.setResponse(Constants.STREAM_DONE);
            gptResponse.setUsage(new Usage(100, 100, 200));
        } else {
            gptResponse.setResponse(WhereQRandom.randomString(1));
            COUNTER--;
        }
        return gptResponse;
    }

    public static GptResponse generateCompletionResponse(String id) {
        GptResponse gptResponse = new GptResponse();
        if (INDEX >= LENGTH) {
            gptResponse.setResponse(Constants.STREAM_DONE);
            gptResponse.setUsage(new Usage(100, 100, 200));
        } else {
            int end = INDEX + WhereQRandom.getRandomInt(30);
            if (end > LENGTH) {
                end = LENGTH;
            }
            gptResponse.setResponse(WhereQ_GPT_Plus.substring(INDEX, end));
            INDEX = end;
        }
        return gptResponse;
    }
}
