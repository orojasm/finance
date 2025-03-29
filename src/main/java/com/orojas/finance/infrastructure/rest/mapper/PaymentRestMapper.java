package com.orojas.finance.infrastructure.rest.mapper;

import com.orojas.finance.domain.model.Payment;
import com.orojas.finance.infrastructure.rest.model.request.PaymentRequest;
import com.orojas.finance.infrastructure.rest.model.response.PaymentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentRestMapper {

    Payment toPayment(PaymentRequest request);
    PaymentResponse toPaymentResponse(Payment payment);
    List<PaymentResponse> toPaymentResponseList(List<Payment> requestList);

}