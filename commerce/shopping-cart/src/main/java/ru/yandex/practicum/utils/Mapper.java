package ru.yandex.practicum.utils;

import ru.yandex.practicum.dto.shoppingCart.ShoppingCartDto;
import ru.yandex.practicum.model.Cart;
import ru.yandex.practicum.model.CartProduct;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Mapper {
    public static ShoppingCartDto toShoppingCartDto(Cart cart) {

        Map<String, Integer> products = cart.getProducts().stream()
                .collect(Collectors.toMap(
                        cartProduct -> cartProduct.getProductId().toString(),
                        CartProduct::getQuantity
                ));

        return ShoppingCartDto.builder()
                .shoppingCartId(cart.getId().toString())
                .products(products)
                .build();
    }

    public static List<CartProduct> toCartProduct(Cart cart, Map<String, Integer> products) {
        return products.entrySet().stream()
                .map(entry -> CartProduct.builder()
                        .cart(cart)
                        .productId(UUID.fromString(entry.getKey()))
                        .quantity(entry.getValue())
                        .build())
                .toList();
    }
}