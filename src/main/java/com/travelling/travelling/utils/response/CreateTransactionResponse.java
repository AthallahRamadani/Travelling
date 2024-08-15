package com.travelling.travelling.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTransactionResponse {
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("token")
    private String token;
    @JsonProperty("redirect_url")
    private String redirectUrl;
}
