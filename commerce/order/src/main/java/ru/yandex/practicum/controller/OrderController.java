package ru.yandex.practicum.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.api.OrderApi;
import ru.yandex.practicum.dto.order.CreateNewOrderRequest;
import ru.yandex.practicum.dto.order.OrderDto;
import ru.yandex.practicum.dto.order.ProductReturnRequest;
import ru.yandex.practicum.service.OrderService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;


    @Override
    public List<OrderDto> getOrders(String username) {
        log.debug("getOrders called for {}", username);
        List<OrderDto> orders = orderService.getOrders(username);
        log.info("User: {} Orders: {}", username, orders);
        return orders;
    }

    @Override
    public OrderDto createOrder(String username, @Valid CreateNewOrderRequest request) {
        log.debug("createOrder called for {}", username);
        log.info("CreateNewOrderRequest: {}", request);
        OrderDto orderDto = orderService.createOrder(username, request);
        log.debug("Create OrderDto: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto returnOrder(@Valid ProductReturnRequest request) {
        log.debug("returnOrder called for request {}", request);
        OrderDto orderDto = orderService.returnOrder(request);
        log.info("Return order: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto payOrder(UUID orderId) {
        log.debug("payOrder called for order {}", orderId);
        OrderDto orderDto = orderService.payOrder(orderId);
        log.info("Pay order: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto payOrderFailed(UUID orderId) {
        log.debug("payOrderFailed called for order {}", orderId);
        OrderDto orderDto = orderService.payOrderFailed(orderId);
        log.info("Pay order failed: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto deliveryOrder(UUID orderId) {
        log.debug("deliveryOrder called for order {}", orderId);
        OrderDto orderDto = orderService.deliveryOrder(orderId);
        log.info("Delivery order: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto deliveryOrderFailed(UUID orderId) {
        log.debug("deliveryOrderFailed called for order {}", orderId);
        OrderDto orderDto = orderService.deliveryOrderFailed(orderId);
        log.info("Delivery order failed: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto completedOrder(UUID orderId) {
        log.debug("completedOrder called for order {}", orderId);
        OrderDto orderDto = orderService.completedOrder(orderId);
        log.info("Completed order: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto calculateTotal(UUID orderId) {
        log.debug("calculateTotal called for order {}", orderId);
        OrderDto orderDto = orderService.calculateTotal(orderId);
        log.info("Calculate total order: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto calculateDelivery(UUID orderId) {
        log.debug("calculateDelivery called for order {}", orderId);
        OrderDto orderDto = orderService.calculateDelivery(orderId);
        log.info("Calculate delivery order: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto assemblyOrder(UUID orderId) {
        log.debug("assemblyOrder called for order {}", orderId);
        OrderDto orderDto = orderService.assemblyOrder(orderId);
        log.info("Assembly order: {}", orderDto);
        return orderDto;
    }

    @Override
    public OrderDto assemblyOrderFailed(UUID orderId) {
        log.debug("assemblyOrderFailed called for order {}", orderId);
        OrderDto orderDto = orderService.assemblyOrderFailed(orderId);
        log.info("Assembly order failed: {}", orderDto);
        return orderDto;
    }
}