package ru.yandex.practicum.clients;

import org.springframework.cloud.openfeign.FeignClient;
import ru.yandex.practicum.api.PaymentApi;

@FeignClient(name = "payment")
public interface PaymentClient extends PaymentApi {

}