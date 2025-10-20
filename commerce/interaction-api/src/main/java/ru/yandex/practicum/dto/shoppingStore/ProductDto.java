package ru.yandex.practicum.dto.shoppingStore;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.dto.shoppingStore.enums.ProductCategory;
import ru.yandex.practicum.dto.shoppingStore.enums.ProductState;
import ru.yandex.practicum.dto.shoppingStore.enums.QuantityState;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ProductDto {
    UUID productId;
    String productName;
    String description;
    String imageSrc;
    QuantityState quantityState;
    ProductState productState;
    ProductCategory productCategory;
    Double price;
}