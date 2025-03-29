package com.orojas.finance.infrastructure.persistence.mapper;

import com.orojas.finance.domain.model.Payment;
import com.orojas.finance.infrastructure.persistence.entity.PaymentEntity;
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