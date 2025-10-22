package ru.yandex.practicum.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.yandex.practicum.dto.shoppingStore.ProductDto;
import ru.yandex.practicum.dto.shoppingStore.enums.ProductCategory;
import ru.yandex.practicum.dto.shoppingStore.enums.QuantityState;

import java.util.UUID;

public interface ShoppingStoreService {

    Page<ProductDto> getProducts(ProductCategory category, Pageable pageable);

    ProductDto getProduct(UUID id);

    ProductDto createProduct(ProductDto productDto);

    void removeProductFromStore(UUID productId);

    void quantityState(UUID productId, QuantityState quantityState);

    ProductDto updateProduct(ProductDto productDto);
}