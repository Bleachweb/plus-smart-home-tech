package ru.yandex.practicum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.api.ShoppingStoreApi;
import ru.yandex.practicum.dto.shoppingStore.ProductDto;
import ru.yandex.practicum.dto.shoppingStore.enums.ProductCategory;
import ru.yandex.practicum.dto.shoppingStore.enums.QuantityState;
import ru.yandex.practicum.service.ShoppingStoreService;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShoppingStoreController implements ShoppingStoreApi {

    private final ShoppingStoreService shoppingStoreService;

    @Override
    public Page<ProductDto> getProducts(ProductCategory category, Pageable pageable) {
        log.debug("getProducts for category {}", category);
        log.debug("getProducts for Pageable {}", pageable);
        Page<ProductDto> products = shoppingStoreService.getProducts(category, pageable);
        log.info("getProducts returned {} products", products.getTotalElements());
        return products;
    }

    @Override
    public ProductDto getProduct(UUID id) {
        log.debug("getProduct with id {}", id);
        ProductDto productDto = shoppingStoreService.getProduct(id);
        log.info("getProduct returned {}", productDto);
        return productDto;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.debug("createProduct {}", productDto);
        ProductDto newProductDto = shoppingStoreService.createProduct(productDto);
        log.info("createProduct returned {}", newProductDto);
        return newProductDto;
    }

    @Override
    public void removeProductFromStore(UUID productId) {
        log.debug("removeProductFromStore with id {}", productId);
        shoppingStoreService.removeProductFromStore(productId);
        log.info("removeProductFromStore was removed");
    }

    @Override
    public void quantityState(UUID productId, QuantityState quantityState) {
        log.debug("quantityState for productId {} ", productId);
        log.debug("quantityState {}", quantityState);
        shoppingStoreService.quantityState(productId, quantityState);
        log.info("quantityState was changed");
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        log.debug("updateProduct {}", productDto);
        ProductDto updatedProductDto = shoppingStoreService.updateProduct(productDto);
        log.info("updateProduct returned {}", updatedProductDto);
        return updatedProductDto;

    }
}