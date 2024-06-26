package com.whereq.llm.openai.vo.edit;

import com.whereq.llm.gpt.vo.BaseVO;

/**
 * An edit generated by OpenAi
 *
 * https://platform.openai.com/docs/api-reference/edits/create
 */
public class EditChoice extends BaseVO {

    /**
     * The edited text.
     */
    String text;

    /**
     * This index of this completion in the returned list.
     */
    Integer index;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "EditChoice{" + "text='" + text + '\'' + ", index=" + index + '}';
    }
}
