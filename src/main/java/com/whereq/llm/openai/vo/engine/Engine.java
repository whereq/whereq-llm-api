package com.whereq.llm.openai.vo.engine;

/**
 * GPT-3 engine details
 *
 * https://platform.openai.com/docs/api-reference/retrieve-engine
 */
@Deprecated
public class Engine {

    /**
     * An identifier for this engine, used to specify an engine for completions or searching.
     */
    public String id;

    /**
     * The type of object returned, should be "engine"
     */
    public String object;

    /**
     * The owner of the GPT-3 engine, typically "openai"
     */
    public String owner;

    /**
     * Whether the engine is ready to process requests or not
     */
    public boolean ready;
}
