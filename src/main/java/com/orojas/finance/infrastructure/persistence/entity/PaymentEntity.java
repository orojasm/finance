package com.orojas.finance.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(generator = "UUID")
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