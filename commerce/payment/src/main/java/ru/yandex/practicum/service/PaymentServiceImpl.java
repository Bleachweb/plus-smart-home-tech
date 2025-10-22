package ru.yandex.practicum.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.clients.OrderClient;
import ru.yandex.practicum.clients.ShoppingStoreClient;
import ru.yandex.practicum.dto.order.OrderDto;
import ru.yandex.practicum.dto.payment.PaymentDto;
import ru.yandex.practicum.dto.payment.enums.PaymentState;
import ru.yandex.practicum.exception.NotFoundException;
import ru.yandex.practicum.model.Payment;
import ru.yandex.practicum.repository.PaymentRepository;
import ru.yandex.practicum.utils.Mapper;

import java.util.UUID;

@Transactional
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ShoppingStoreClient shoppingStoreClient;
    private final OrderClient orderClient;


    @Override
    public PaymentDto createPayment(OrderDto orderDto) {
        Payment payment = Payment.builder()
                .state(PaymentState.PENDING)
                .deliveryTotal(orderDto.getDeliveryPrice())
                .feeTotal(getFee(orderDto.getTotalPrice()))
                .totalPayment(orderDto.getTotalPrice())
                .orderId(orderDto.getOrderId())
                .build();

        paymentRepository.save(payment);
        return Mapper.toPaymentDto(payment);
    }

    @Override
    public Double totalCost(OrderDto orderDto) {

        /*
        a. От суммы стоимости всех товаров нужно взять 10% — это будет НДС.
        Например, если товар стоит 100 рублей, то НДС составит 10 рублей.
        b. Налог прибавляем к стоимости товара, получим 110 рублей.
        c. Добавляем стоимость доставки — 50 рублей. И в итоге пользователь видит сумму: 160 рублей.
         */
        Double productPrice = orderDto.getProductPrice();
        Double deliveryPrice = orderDto.getDeliveryPrice();
        Double feeTotal = getFee(productPrice);
        return productPrice + deliveryPrice + feeTotal;
    }

    private static Double getFee(Double productPrice) {
        return productPrice * 0.1;
    }

    @Override
    public void refund(UUID paymentId) {
        Payment payment = getPayment(paymentId);
        payment.setState(PaymentState.SUCCESS);
        paymentRepository.save(payment);
        orderClient.payOrder(payment.getOrderId());
    }

    private Payment getPayment(UUID paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(
                () -> new NotFoundException("Payment with id " + paymentId + " not found")
        );
    }

    @Override
    public Double productCost(OrderDto order) {
        return order.getProducts().keySet().stream()
                .mapToDouble(productId -> shoppingStoreClient.getProduct(productId).getPrice())
                .sum();
    }

    @Override
    public void failed(UUID paymentId) {
        Payment payment = getPayment(paymentId);
        payment.setState(PaymentState.FAILED);
        paymentRepository.save(payment);
        orderClient.payOrderFailed(payment.getOrderId());
    }
}