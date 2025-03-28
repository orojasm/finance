package com.orojas.finance.infrastructure.adapters.input.rest.model.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private UUID id;
    private String period;
    private String description;
    private String currency;
    private BigDecimal amountToPay;
    private BigDecimal amountPaid;
    private LocalDateTime dueDate;
    private LocalDateTime paymentDate;
    private String reference;
    private String website;
    private String budget;
    private String category;
    private String type;
    private String tags;
    private String recipient;
    private String sourceAccount;
    private String destinationAccount;
    private String status;
    private LocalDateTime createdAt;
}