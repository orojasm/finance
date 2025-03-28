package com.orojas.finance.infrastructure.adapters.output.persistence.mapper;

import com.orojas.finance.domain.model.Payment;
import com.orojas.finance.infrastructure.adapters.output.persistence.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentPersistenceMapper {


    PaymentEntity toPaymentEntity(Payment payment);

    @Mapping(target = "id", source = "id")
    Payment toPayment(PaymentEntity entity);

    List<Payment> toPaymentList(List<PaymentEntity> entityList);

}