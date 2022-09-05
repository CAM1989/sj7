package com.geekbrains.tests;

import com.geekbrains.spring.web.cart.dto.Cart;
import com.geekbrains.spring.web.cart.dto.ProductDto;
import com.geekbrains.spring.web.cart.services.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CartService.class)
@TestConfiguration
public class CartServiceTest {

    final String cartName = "testCart";

    @Mock
    private RestTemplate restTemplate;
    @Autowired
    private CartService cartService;

    @BeforeEach
    public void initCart() {cartService.clear(cartName);
    }

    @Test
    public void addToCartTest() {
        ProductDto pdt = new ProductDto(1L, "test", 10);
        Cart cart = cartService.getCurrentCart(cartName);
        cart.addProduct(pdt);
        cart.addProduct(pdt);
        cart.addProduct(pdt);
        cart.addProduct(pdt);
        cart.addProduct(pdt);
        assertThat(cart.getTotalPrice()).isEqualTo(50);
    }

    @Test
    public void testClearCart() {
        ProductDto pdt = new ProductDto(1L, "test", 10);
        Cart cart = cartService.getCurrentCart(cartName);
        cart.addProduct(pdt);
        assertThat(cart.getTotalPrice()).isGreaterThan(0);
        cartService.clear(cartName);
        assertThat(cartService.getCurrentCart(cartName).getTotalPrice()).isEqualTo(0);
    }
}
