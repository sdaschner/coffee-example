package com.sebastian_daschner.coffee_shop.orders.boundary;

import com.sebastian_daschner.coffee_shop.orders.control.OrderProcessorTestDouble;
import com.sebastian_daschner.coffee_shop.orders.entity.CoffeeType;
import com.sebastian_daschner.coffee_shop.orders.entity.Order;
import com.sebastian_daschner.coffee_shop.orders.entity.Origin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class CoffeeShopTest {

    private CoffeeShopTestDouble coffeeShop;
    private OrderProcessorTestDouble orderProcessor;

    @BeforeEach
    void setUp() {
        orderProcessor = new OrderProcessorTestDouble();
        coffeeShop = new CoffeeShopTestDouble(orderProcessor);
    }

    @Test
    void testCreateOrder() {
        Order order = new Order();
        coffeeShop.createOrder(order);
        coffeeShop.verifyCreateOrder(order);
    }

    @Test
    void testProcessUnfinishedOrders() {
        List<Order> orders = Arrays.asList(new Order(UUID.randomUUID(), CoffeeType.ESPRESSO, new Origin("Colombia")),
                new Order(UUID.randomUUID(), CoffeeType.ESPRESSO, new Origin("Ethiopia")));
        coffeeShop.answerForUnfinishedOrders(orders);

        coffeeShop.processUnfinishedOrders();

        coffeeShop.verifyProcessUnfinishedOrders();
        orderProcessor.verifyProcessOrders(orders);
    }

}
