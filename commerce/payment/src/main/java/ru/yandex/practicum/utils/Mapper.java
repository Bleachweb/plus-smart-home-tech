package ru.yandex.practicum.utils;

import ru.yandex.practicum.dto.payment.PaymentDto;
import ru.yandex.practicum.model.Payment;

public class Mapper {

    public static PaymentDto toPaymentDto(Payment payment) {
        return PaymentDto.builder()
                .feeTotal(payment.getFeeTotal())
                .deliveryTotal(payment.getDeliveryTotal())
                .paymentId(payment.getPaymentId())
                .totalPayment(payment.getTotalPayment())
                .build();
    }
}