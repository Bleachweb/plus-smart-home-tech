package ru.yandex.practicum;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.model.Cart;
import ru.yandex.practicum.model.enums.CartState;

import java.util.Optional;
import java.util.UUID;

public interface ShoppingCartRepository extends JpaRepository<Cart, UUID> {

    Optional<Cart> findByUsernameAndState(String username, CartState state);
}