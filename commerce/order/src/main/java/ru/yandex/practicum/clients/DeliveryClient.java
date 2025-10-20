package ru.yandex.practicum.clients;

import org.springframework.cloud.openfeign.FeignClient;
import ru.yandex.practicum.api.DeliveryApi;

@FeignClient(name = "delivery")
public interface DeliveryClient extends DeliveryApi {
}