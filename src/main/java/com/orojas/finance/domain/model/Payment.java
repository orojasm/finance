package com.orojas.finance.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
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

    public Payment(String period, String description, double amountToPay, String reference, LocalDate dueDate, String status) {
        this.period = period;
        this.description = description;
        this.currency = "COL";
        this.amountToPay = BigDecimal.valueOf(amountToPay);
        this.amountPaid = BigDecimal.valueOf(amountToPay);
        this.dueDate = LocalDateTime.now();
        this.paymentDate = LocalDateTime.now();
        this.reference = reference;
        this.website = "";
        this.budget = "";
        this.category = "";
        this.type = "";
        this.tags = "";
        this.recipient = "";
        this.sourceAccount = "";
        this.destinationAccount = "";
        this.createdAt = LocalDateTime.now();
        this.status = status;
    }
}