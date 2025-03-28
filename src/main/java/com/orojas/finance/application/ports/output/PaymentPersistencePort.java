package com.orojas.finance.application.ports.output;

import com.orojas.finance.domain.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentPersistencePort {

    Payment save(Payment payment);
    List<Payment> findAll();
    Optional<Payment> findById(UUID id);
    void delete(UUID id);
    void saveAll(List<Payment> payments);

}