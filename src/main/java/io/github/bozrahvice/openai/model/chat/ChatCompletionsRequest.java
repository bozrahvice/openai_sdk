package io.github.bozrahvice.openai.model.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bozrahvice.openai.model.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatCompletionsRequest implements Serializable {

    private static final long serialVersionUID = -945426510431833578L;
    /**
     * ID of the model to use. Currently, only gpt-3.5-turbo and gpt-3.5-turbo-0301 are supported.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("model")
    private String model;

    /**
     * The messages to generate chat completions for, in the chat format
     *
     * @link https://platform.openai.com/docs/guides/chat/introduction
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("messages")
    private List<Message> messages;

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
     * <p>
     * We generally recommend altering this or top_p but not both.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("temperature")
    private Number temperature;

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     * <p>
     * We generally recommend altering this or temperature but not both.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("top_p")
    private Number topP;

    /**
     * How many chat completion choices to generate for each input message.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("n")
    private Integer n;

    /**
     * boolean
     * Optional
     * Defaults to false
     * If set, partial message deltas will be sent, like in ChatGPT. Tokens will be sent as data-only server-sent events as they become available, with the stream terminated by a data: [DONE] message.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stream")
    private boolean stream;

    /**
     * Optional
     * Defaults to null
     * Up to 4 sequences where the API will stop generating further tokens.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("stop")
    private String stop;

    /**
     * Optional
     * Defaults to inf
     * The maximum number of tokens allowed for the generated answer. By default, the number of tokens the model can return will be (4096 - prompt tokens).
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("max_tokens")
    private Integer maxTokens;

    /**
     * number
     * Optional
     * Defaults to 0
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing frequency in the text so far, decreasing the model's likelihood to repeat the same line verbatim.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("presence_penalty")
    private Number presencePenalty;

    /**
     * Optional
     * Defaults to null
     * Modify the likelihood of specified tokens appearing in the completion.
     * <p>
     * Accepts a json object that maps tokens (specified by their token ID in the tokenizer) to an associated bias value from -100 to 100. Mathematically, the bias is added to the logits generated by the model prior to sampling. The exact effect will vary per model, but values between -1 and 1 should decrease or increase likelihood of selection; values like -100 or 100 should result in a ban or exclusive selection of the relevant token.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("logit_bias")
    private Map logItBias;

    /**
     * Optional
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse. Learn more.
     * @link https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("user")
    private String user;


}