package com.travelling.travelling.utils.dto;

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
public class Transaction {

    @JsonProperty("transaction_details")
    TransactionDetails transactionDetails;
    @JsonProperty("customer_details")
    CustomerDetails customerDetails;
    @JsonProperty("expiry")
    Expiry expiry;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TransactionDetails {
        String order_id;
        Integer gross_amount;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Expiry {
        @JsonProperty("unit")
        String unit;
        @JsonProperty("duration")
        Integer duration;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CustomerDetails {
        String first_name;
        String email;
    }
}