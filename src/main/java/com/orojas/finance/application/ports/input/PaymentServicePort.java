package com.orojas.finance.application.ports.input;

import com.orojas.finance.domain.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentServicePort {

    Payment createPayment(Payment payment);
    List<Payment> getPayments();
    Payment getPaymentById(UUID id);
    Payment updatePayment(UUID id, Payment payment);
    void deletePayment(UUID id);
    String populatePayments(String period);

}