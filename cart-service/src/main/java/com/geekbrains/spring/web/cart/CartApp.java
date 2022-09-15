package com.geekbrains.spring.web.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
public class CartApp {
    public static void main(String[] args) {
        SpringApplication.run(CartApp.class, args);
    }
}
