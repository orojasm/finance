package com.orojas.finance.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class PaymentRequest {
    private UUID id;
    @Size(min = 6, max = 6)
    private String period;
    @NotEmpty(message = "Field description cannot be blank, empty or null.")
    private String description;
    private String currency;
    private BigDecimal amountToPay;
    private BigDecimal amountPaid;
    @NotNull(message = "Field dueDate cannot be null.")
    private LocalDateTime dueDate;
    private LocalDateTime paymentDate;
    private String reference;
    private String website;
    private String budget;
    @NotBlank(message = "Field category cannot be blank, empty or null.")
    private String category;
    private String type;
    private String tags;
    private String recipient;
    @NotEmpty(message = "Field sourceAccount cannot be empty or null.")
    private String sourceAccount;
    @NotEmpty(message = "Field destinationAccount cannot be empty or null.")
    private String destinationAccount;
    private String status;
    private LocalDateTime createdAt;
}