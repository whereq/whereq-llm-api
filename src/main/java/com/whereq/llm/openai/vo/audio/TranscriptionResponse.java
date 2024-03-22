package com.whereq.llm.openai.vo.audio;

import com.whereq.llm.gpt.vo.BaseVO;

/**
 * A request for OpenAi to turn an audio file into text.
 *
 * https://platform.openai.com/docs/api-reference/audio
 */
public class TranscriptionResponse extends BaseVO {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TranscriptionResponse{" + "text='" + text + '\'' + '}';
    }
}
