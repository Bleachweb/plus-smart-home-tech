package ru.yandex.practicum.service;

import ru.yandex.practicum.dto.shoppingCart.ShoppingCartDto;
import ru.yandex.practicum.dto.warehouse.AddProductToWarehouseRequest;
import ru.yandex.practicum.dto.warehouse.AddressDto;
import ru.yandex.practicum.dto.warehouse.BookedProductsDto;
import ru.yandex.practicum.dto.warehouse.NewProductInWarehouseRequest;

public interface WarehouseService {

    void addNewProduct(NewProductInWarehouseRequest request);

    BookedProductsDto checkCart(ShoppingCartDto shoppingCartDto);

    void addProduct(AddProductToWarehouseRequest request);

    AddressDto getAddress();
}