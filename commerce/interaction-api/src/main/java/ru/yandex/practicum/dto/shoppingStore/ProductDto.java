package ru.yandex.practicum.dto.shoppingStore;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.dto.shoppingStore.enums.ProductCategory;
import ru.yandex.practicum.dto.shoppingStore.enums.ProductState;
import ru.yandex.practicum.dto.shoppingStore.enums.QuantityState;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ProductDto {
    String productId;
    String productName;
    String description;
    String imageSrc;
    QuantityState quantityState;
    ProductState productState;
    ProductCategory productCategory;
    Double price;
}