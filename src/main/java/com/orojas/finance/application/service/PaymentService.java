package com.orojas.finance.application.service;

import com.orojas.finance.application.ports.input.PaymentServicePort;
import com.orojas.finance.application.ports.output.PaymentPersistencePort;
import com.orojas.finance.domain.exception.PaymentNotFoundException;
import com.orojas.finance.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PaymentService implements PaymentServicePort {
    private final PaymentPersistencePort persistencePort;

    @Override
    public Payment createPayment(Payment payment) {
        return persistencePort.save(payment);
    }

    @Override
    public List<Payment> getPayments() {
        return persistencePort.findAll();
    }

    @Override
    public Payment getPaymentById(UUID id) {
        return persistencePort.findById(id)
                .orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public Payment updatePayment(UUID id, Payment payment) {
        return persistencePort.findById(id)
                .map(savePayment -> {
                  savePayment.setPeriod(payment.getPeriod());
                  savePayment.setDescription(payment.getDescription());
                  savePayment.setCurrency(payment.getCurrency());
                  savePayment.setAmountToPay(payment.getAmountToPay());
                  savePayment.setAmountPaid(payment.getAmountPaid());
                  savePayment.setDueDate(payment.getDueDate());
                  savePayment.setPaymentDate(payment.getPaymentDate());
                  savePayment.setReference(payment.getReference());
                  savePayment.setWebsite(payment.getWebsite());
                  savePayment.setBudget(payment.getBudget());
                  savePayment.setCategory(payment.getCategory());
                  savePayment.setType(payment.getType());
                  savePayment.setTags(payment.getTags());
                  savePayment.setRecipient(payment.getRecipient());
                  savePayment.setSourceAccount(payment.getSourceAccount());
                  savePayment.setDestinationAccount(payment.getDestinationAccount());
                  savePayment.setStatus(payment.getStatus());
                  return persistencePort.save(savePayment);
                })
                .orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public void deletePayment(UUID id) {
        if (persistencePort.findById(id).isEmpty()) {
            throw new PaymentNotFoundException();
        }
        persistencePort.delete(id);
    }

    @Override
    public String populatePayments(String period) {
        List<Payment> payments = Arrays.asList(
            new Payment(period, "Pago Dinners", 449980.0, "", LocalDate.of(2025, 3, 4),"DONE"),
            new Payment(period, "Pago Crediexpress", 3276000.0, "3695587-5", LocalDate.of(2025,3,5),"DONE"),
            new Payment(period, "ENEL Apto", -1.0, "", LocalDate.of(2025,3,20), "INITIAL"),
            new Payment(period, "Parafiscales", 488500.0, "https://independientes2.miplanilla.com/PublicoIndependientes/Publico/IndexIndependientes", LocalDate.of(2025,3,8), "DONE"),
            new Payment(period, "ENEL of 701", 68440.0, "Enel Colombia SA ESP - 1000203 <04389771>", LocalDate.of(2025, 3, 13), "DONE"),
            new Payment(period, "ENEL of 702", 70950.0, "Enel Colombia SA ESP - 1000203 <04389783>", LocalDate.of(2025, 3, 13), "DONE"),
            new Payment(period, "ENEL of 602", 627710.0, "Enviar a Masters Group <04389769>", LocalDate.of(2025,3,13), "DONE"),
            new Payment(period, "Gas domiciliario Apto", 65530.0, "Pago automático Davivienda", LocalDate.of(2025,3,12), "DONE"),
            new Payment(period, "Admon Apto", 495100.0, "https://www.pagosvirtualesavvillas.com.co/personal/pagos/3870", LocalDate.of(2025, 3, 15), "DONE"),
            new Payment(period, "Admon of 701", 1224000.0, "$2197500 = $1224000 + $973500", LocalDate.of(2025,3,15), "DONE"),
            new Payment(period, "Admon of 702", 973500.0, "", LocalDate.of(2025,3,15), "DONE"),
            new Payment(period, "Admon of 602", 1068500.0, "Enviar a Masters Group", LocalDate.of(2025,3,15), "DONE"),
            new Payment(period, "Banco Falabella", 66610.0, "https://banco-co-gateway-pagos.fif.tech/payment/Index.html#!/login", LocalDate.of(2025,3,15), "DONE"),
            new Payment(period, "Arriendo Estudio", 310000.0, "", LocalDate.of(2025,3,16), "DOING"),
            new Payment(period, "Ayuda a Rocio", 300000.0, "", LocalDate.of(2025,3,16), "DOING"),
            new Payment(period, "Pago Mastercard",  1802585.0, "", LocalDate.of(2025,3,20), "TODO"),
            new Payment(period, "Pago Visa", 2892181.0, "", LocalDate.of(2025,3,20), "TODO"),
            new Payment(period, "EAAB of 701", 0.0, "https://pagos.acueducto.com.co/?cc=11846630", LocalDate.of(2025,4,10), "N.A."),
            new Payment(period, "EAAB of 702", 0.0, "https://pagos.acueducto.com.co/?cc=11846631", LocalDate.of(2025,4,10), "N.A."),
            new Payment(period, "EAAB of 602", 0.0, "Enviar a Masters Group <11846629>", LocalDate.of(2025,4,10), "N.A."),
            new Payment(period, "EAAB Apto", 0.0, "https://pagos.acueducto.com.co/?cc=12072340", LocalDate.of(2025,4,20), "N.A."),
            new Payment(period, "Internet Hogar", 88038.0, "", LocalDate.of(2025,3,20), "TODO"),
            new Payment(period, "Telefonia Movil ORojas", 27596.0, "", LocalDate.of(2025,3,4), "DONE"),
            new Payment(period, "Telefonia Movil JDavid", 27596.0, "", LocalDate.of(2025,3,12), "DONE"),
            new Payment(period, "Colsanitas", 488500.0, "", LocalDate.of(2025,3,30), "INITIAL")
        );
        String msg = "Populate " + period + ", add " + payments.size() + " new payments";
        persistencePort.saveAll(payments);
        return msg;
    }
}
