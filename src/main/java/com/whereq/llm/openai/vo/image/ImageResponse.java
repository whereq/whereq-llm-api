package com.whereq.llm.openai.vo.image;

import com.whereq.llm.gpt.vo.BaseVO;
import java.util.List;

/**
 * An object with a list of image results.
 *
 * https://platform.openai.com/docs/api-reference/images
 */
public class ImageResponse extends BaseVO {

    /**
     * The creation time in epoch seconds.
     */
    Long created;

    /**
     * List of image results.
     */
    List<Image> data;

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public List<Image> getData() {
        return data;
    }

    public void setData(List<Image> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ImageReponse{" + "created=" + created + ", data=" + data + '}';
    }
}
