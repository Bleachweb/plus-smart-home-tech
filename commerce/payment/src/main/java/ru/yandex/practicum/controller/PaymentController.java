package ru.yandex.practicum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.api.PaymentApi;
import ru.yandex.practicum.dto.order.OrderDto;
import ru.yandex.practicum.dto.payment.PaymentDto;
import ru.yandex.practicum.service.PaymentService;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController implements PaymentApi {

    private final PaymentService paymentService;

    @Override
    public PaymentDto createPayment(OrderDto order) {
        PaymentDto payment = paymentService.createPayment(order);
        log.info("Payment created: {} for order: {}", payment, order);
        return payment;
    }

    @Override
    public Double totalCost(OrderDto orderDto) {
        Double cost = paymentService.totalCost(orderDto);
        log.info("Total cost: {} for order: {}", cost, orderDto);
        return cost;
    }

    @Override
    public void refund(UUID paymentId) {
        log.debug("Refund paymentId: {}", paymentId);
        paymentService.refund(paymentId);
        log.info("Payment was refunded: {} ", paymentId);
    }

    @Override
    public Double productCost(OrderDto order) {
        Double cost = paymentService.productCost(order);
        log.info("Product cost is: {} for order: {}", cost, order);
        return cost;
    }

    @Override
    public void failed(UUID paymentId) {
        log.debug("Request for payment failed: {}", paymentId);
        paymentService.failed(paymentId);
        log.info("Payment was failed: {}", paymentId);
    }
}