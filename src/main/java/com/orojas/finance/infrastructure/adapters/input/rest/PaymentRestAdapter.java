package com.orojas.finance.infrastructure.adapters.input.rest;

import com.orojas.finance.application.ports.input.PaymentServicePort;
import com.orojas.finance.domain.model.Payment;
import com.orojas.finance.infrastructure.adapters.input.rest.mapper.PaymentRestMapper;
import com.orojas.finance.infrastructure.adapters.input.rest.model.request.PaymentRequest;
import com.orojas.finance.infrastructure.adapters.input.rest.model.response.PaymentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentRestAdapter {
    private final PaymentServicePort servicePort;
    private final PaymentRestMapper restMapper;

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@Valid @RequestBody PaymentRequest request) {
        log.info("POST /payments *** {}", request.getDescription());
        Payment payment = servicePort.createPayment(restMapper.toPayment(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toPaymentResponse(payment));
    }

    @GetMapping()
    public List<PaymentResponse> getPayments() {
        log.info("GET /payments");
        return restMapper.toPaymentResponseList(servicePort.getPayments());
    }

    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(@PathVariable UUID id) {
        log.info("GET /payments/{}", id);
        return restMapper.toPaymentResponse(servicePort.getPaymentById(id));
    }

    @PutMapping("/{id}")
    public PaymentResponse updatePayment(@PathVariable UUID id, @Valid @RequestBody PaymentRequest request) {
        log.info("PUT /payments/{} *** {}", id, request.getDescription());
        return restMapper.toPaymentResponse(
                servicePort.updatePayment(id, restMapper.toPayment(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        log.info("DELETE /payments/{}", id);
        servicePort.deletePayment(id);
    }

    @PostMapping("/populate/{period}")
    public ResponseEntity<String> populatePayments(@PathVariable String period) {
        log.info("POST payments/populate/{}", period);
        String msg = servicePort.populatePayments(period);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}