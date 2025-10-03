package ru.yandex.practicum.service;

import ru.yandex.practicum.dto.shoppingCart.ChangeProductQuantityRequest;
import ru.yandex.practicum.dto.shoppingCart.ShoppingCartDto;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {

    ShoppingCartDto getShoppingCart(String username);

    ShoppingCartDto updateShoppingCart(String username, Map<String, Integer> products);

    void deleteShoppingCart(String username);

    ShoppingCartDto removeProductsFromShoppingCart(String username, List<String> products);

    ShoppingCartDto changeQuantityShoppingCart(String username, ChangeProductQuantityRequest request);
}