package com.whereq.llm.openai.vo.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whereq.llm.gpt.vo.BaseVO;

/**
 * Fine-tuning job hyperparameters
 *
 * https://platform.openai.com/docs/api-reference/fine-tunes
 */
public class HyperParameters extends BaseVO {

    /**
     * The batch size to use for training.
     */
    @JsonProperty("batch_size")
    Integer batchSize;

    /**
     * The learning rate multiplier to use for training.
     */
    @JsonProperty("learning_rate_multiplier")
    Double learningRateMultiplier;

    /**
     * The number of epochs to train the model for.
     */
    @JsonProperty("n_epochs")
    Integer nEpochs;

    /**
     * The weight to use for loss on the prompt tokens.
     */
    @JsonProperty("prompt_loss_weight")
    Double promptLossWeight;
}
