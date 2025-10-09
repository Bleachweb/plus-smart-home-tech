package ru.yandex.practicum.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.ShoppingCartRepository;
import ru.yandex.practicum.client.WarehouseClient;
import ru.yandex.practicum.dto.shoppingCart.ChangeProductQuantityRequest;
import ru.yandex.practicum.dto.shoppingCart.ShoppingCartDto;
import ru.yandex.practicum.exception.NotAuthorizedUserException;
import ru.yandex.practicum.model.Cart;
import ru.yandex.practicum.model.CartProduct;
import ru.yandex.practicum.model.enums.CartState;
import ru.yandex.practicum.utils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final WarehouseClient warehouseClient;

    @Override
    public ShoppingCartDto getShoppingCart(String username) {

        return Mapper.toShoppingCartDto(findShoppingCart(username));
    }

    @Override
    public ShoppingCartDto updateShoppingCart(String username, Map<String, Integer> products) {

        Cart cart = shoppingCartRepository.findByUsernameAndState(username, CartState.ACTIVE)
                .orElseGet( () -> {
                    Cart newCart = Cart.builder()
                            .username(username)
                            .products(new ArrayList<>())
                            .state(CartState.ACTIVE)
                            .build();
                    return shoppingCartRepository.save(newCart);
                });
        log.info("Shopping cart before update {}", cart);


        ShoppingCartDto shoppingCartDto = ShoppingCartDto.builder()
                .shoppingCartId(cart.getId().toString())
                .products(products)
                .build();

        warehouseClient.checkCart(shoppingCartDto);


        List<CartProduct> cartProduct = cart.getProducts();
        List<CartProduct> cartProductsToUpdate = Mapper.toCartProduct(cart, products);
        cartProduct.addAll(cartProductsToUpdate);

        log.info("Shopping cart after update {}", cart);

        shoppingCartRepository.save(cart);

        log.info("Updated shopping cart {}", cart);

        return Mapper.toShoppingCartDto(cart);

    }

    @Override
    public void deleteShoppingCart(String username) {
        Cart cart = findShoppingCart(username);
        cart.setState(CartState.DEACTIVATE);
        shoppingCartRepository.save(cart);
    }

    @Override
    public ShoppingCartDto removeProductsFromShoppingCart(String username, List<String> products) {
        Cart cart = findShoppingCart(username);
        List<CartProduct> cartProduct = cart.getProducts();
        cartProduct.removeIf(cp -> products.contains(cp.getProductId().toString()));

        cart.setProducts(cartProduct);

        shoppingCartRepository.save(cart);

        return Mapper.toShoppingCartDto(cart);
    }

    @Override
    public ShoppingCartDto changeQuantityShoppingCart(String username, ChangeProductQuantityRequest request) {
        Cart cart = findShoppingCart(username);

        cart.getProducts().stream()
                .filter(cp -> cp.getProductId().equals(UUID.fromString(request.getProductId())))
                .findFirst()
                .ifPresent(cp -> cp.setQuantity(request.getNewQuantity()));

        shoppingCartRepository.save(cart);
        return Mapper.toShoppingCartDto(cart);
    }

    private Cart findShoppingCart(String username) {
        return shoppingCartRepository.findByUsernameAndState(username, CartState.ACTIVE)
                .orElseThrow(() -> new NotAuthorizedUserException("Корзина пользователя с таким username: " + username + " не найдена"));
    }
}