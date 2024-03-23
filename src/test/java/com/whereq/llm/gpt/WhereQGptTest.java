package com.whereq.llm.gpt;

import com.whereq.llm.config.WhereQConfiguration;
import com.whereq.llm.gpt.enums.LengthEnum;
import com.whereq.llm.gpt.vo.GptParameter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WhereQConfiguration.class, WhereQGptTest.class })
public class WhereQGptTest {

    @Test
    public void testGptParameter() throws Exception {
        String task = "task";
        String topic = "topic";
        String style = "default";
        String tone = "default";
        String audience = "default";
        String length = "20 words";
        String format = "default";
        GptParameter gptParameter = new GptParameter(task, topic, style, tone, audience, length, format);
        System.out.println(gptParameter);
    }

    @Test
    public void testEnums() throws Exception {
        String lengthEnumString = "20 words";
        LengthEnum lengthEnum = LengthEnum.fromString(lengthEnumString);
        System.out.println(lengthEnum);
    }
}
