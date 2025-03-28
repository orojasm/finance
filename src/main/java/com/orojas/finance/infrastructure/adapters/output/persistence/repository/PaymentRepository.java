package com.orojas.finance.infrastructure.adapters.output.persistence.repository;

import com.orojas.finance.infrastructure.adapters.output.persistence.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
}