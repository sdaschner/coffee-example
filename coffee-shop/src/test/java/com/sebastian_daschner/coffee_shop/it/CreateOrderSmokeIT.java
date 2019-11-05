package com.sebastian_daschner.coffee_shop.it;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CreateOrderSmokeIT {

    private CoffeeOrderSystem coffeeOrderSystem;

    @BeforeEach
    void setUp() {
        coffeeOrderSystem = new CoffeeOrderSystem();
    }

    @Test
    void createVerifyOrder() {
        List<URI> originalOrders = coffeeOrderSystem.getOrders();

        Order order = new Order("Espresso", "Colombia");
        URI orderUri = coffeeOrderSystem.createOrder(order);

        Order loadedOrder = coffeeOrderSystem.getOrder(orderUri);
        assertThat(loadedOrder).isEqualToComparingOnlyGivenFields(order, "type", "origin");

        assertThat(coffeeOrderSystem.getOrders()).hasSize(originalOrders.size() + 1);
    }

}