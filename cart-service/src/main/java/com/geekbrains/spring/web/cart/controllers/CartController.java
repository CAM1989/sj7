package com.geekbrains.spring.web.cart.controllers;

import com.geekbrains.spring.web.cart.dto.Cart;
import com.geekbrains.spring.web.cart.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
@Tag(name = "Корзина", description = "Контроллер корзины")
public class CartController {
    private final CartService service;

    @Operation(description = "Получить текущую корзину")
    @PostMapping
    public Cart getCurrentCart(@RequestBody String cartName){
        return service.getCurrentCart(cartName);
    }

    @Operation(description = "Добавить товар в корзину")
    @PostMapping("/add/{id}")
    public void addProductToCart(@PathVariable Long id, @RequestBody String cartName){
        service.addProductByIdToCart(id, cartName);
    }
    @Operation(description = "Очистить корзину")
    @PostMapping("/clear")
    public void clearCart(@RequestBody String cartName){
        service.clear(cartName);
    }

    @Operation(description = "Удалить товар из корзины")
    @PostMapping("/remove/{id}")
    public void removeProductFromCart(@PathVariable Long id, @RequestBody String cartName) {
        service.removeProductByIdFromCart(id, cartName);
    }

}
