package com.orojas.finance.infrastructure.persistence;

import com.orojas.finance.application.ports.output.PaymentPersistencePort;
import com.orojas.finance.domain.model.Payment;
import com.orojas.finance.infrastructure.persistence.entity.PaymentEntity;
import com.orojas.finance.infrastructure.persistence.mapper.PaymentPersistenceMapper;
import com.orojas.finance.infrastructure.persistence.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentPersistenceAdapter implements PaymentPersistencePort {
    private final PaymentRepository repository;
    private final PaymentPersistenceMapper mapper;

    @Override
    public Payment save(Payment payment) {
        log.info("************ Create or Update Payment ************");
        log.info(payment.toString());
        return mapper.toPayment(
            repository.save(mapper.toPaymentEntity(payment))
        );
    }

    @Override
    public List<Payment> findAll() {
        List<PaymentEntity> paymentEntityList = repository.findAll();
        log.info("************ List Payment, Records: {} ************", paymentEntityList.size());
        return mapper.toPaymentList(paymentEntityList);
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        log.info("************ Get Payment : {} ************", id);
        return repository.findById(id)
                .map(mapper::toPayment);
    }

    @Override
    public void delete(UUID id) {
        log.info("************ Delete Payment : {} ************", id);
        repository.deleteById(id);
    }

    @Override
    public void saveAll(List<Payment> paymentList) {
        // Save population
        paymentList.forEach(payment -> {
            repository.save(mapper.toPaymentEntity(payment));
        });

        // Display
        List<PaymentEntity> paymentEntityList = repository.findAll();
        log.info("************ Populate Payments ************");
        paymentEntityList.forEach((payment) -> log.info(payment.toString()));
        log.info("********** END Populate Payments **********");
        return;
    }

}