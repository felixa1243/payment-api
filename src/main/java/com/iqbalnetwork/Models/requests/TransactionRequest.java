package com.iqbalnetwork.Models.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class TransactionRequest {
    String id;
    @NotBlank
    private String customerId;
    @NotBlank
    private String transactionId;
    @Pattern(regexp = "PAYMENT")
    private String transactionType;
}
