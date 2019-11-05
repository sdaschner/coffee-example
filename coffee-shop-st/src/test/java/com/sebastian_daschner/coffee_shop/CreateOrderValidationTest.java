package com.sebastian_daschner.coffee_shop;

import com.sebastian_daschner.coffee_shop.entity.Order;
import com.sebastian_daschner.coffee_shop.systems.BaristaSystem;
import com.sebastian_daschner.coffee_shop.systems.CoffeeOrderSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CreateOrderValidationTest {

    private CoffeeOrderSystem coffeeOrderSystem;

    @BeforeEach
    void setUp() {
        coffeeOrderSystem = new CoffeeOrderSystem();
    }

    @Test
    void invalidEmptyOrder() {
        coffeeOrderSystem.createInvalidOrder(new Order());
    }

    @Test
    void invalidEmptyCoffeeType() {
        createOrder(null, "Colombia");
    }

    @Test
    void invalidEmptyOrigin() {
        createOrder("Espresso", null);
    }

    @Test
    void invalidCoffeeType() {
        createOrder("Siphon", "Colombia");
    }

    @Test
    void invalidCoffeeOrigin() {
        createOrder("Espresso", "Germany");
    }

    @Test
    void invalidEmptyCoffeeTypeInvalidOrigin() {
        createOrder(null, "Germany");
    }

    @Test
    void invalidEmptyOriginInvalidCoffeeType() {
        createOrder("Siphon", null);
    }

    private void createOrder(String o, String colombia) {
        Order order = new Order(o, colombia);
        coffeeOrderSystem.createInvalidOrder(order);
    }

}