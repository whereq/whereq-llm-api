package com.whereq.llm.openai.vo;

/**
 * A response when deleting an object
 */
public class DeleteResult {

    /**
     * The id of the object.
     */
    String id;

    /**
     * The type of object deleted, for example "file" or "model"
     */
    String object;

    /**
     * True if successfully deleted
     */
    boolean deleted;
}
