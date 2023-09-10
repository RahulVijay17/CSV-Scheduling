package com.example.scheduling.csvreport.service;

import com.example.scheduling.csvreport.Model.Order;
import com.example.scheduling.csvreport.Model.OrderItem;
import com.example.scheduling.csvreport.Model.OrderStatus;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();

    public OrderService() {
        // Initialize five sample orders with order items and all fields filled
        orders.add(new Order(
                1L,               // id
                "12345",          // orderNumber
                new Date(),       // orderDate
                Arrays.asList(
                        new OrderItem(1L, "Product A", new BigDecimal("25.00"), 2),
                        new OrderItem(2L, "Product B", new BigDecimal("50.00"), 1)
                ), // orderItems
                new BigDecimal("100.00"), // totalAmount
                "123 Main St, City, Country", // shippingAddress
                "Credit Card",    // paymentMethod
                OrderStatus.PENDING // status
        ));

        orders.add(new Order(
                2L,               // id
                "67890",          // orderNumber
                new Date(),       // orderDate
                Arrays.asList(
                        new OrderItem(3L, "Product C", new BigDecimal("30.00"), 3)
                ), // orderItems
                new BigDecimal("120.00"), // totalAmount
                "456 Elm St, Another City, Another Country", // shippingAddress
                "PayPal",         // paymentMethod
                OrderStatus.PROCESSING // status
        ));

        orders.add(new Order(
                3L,               // id
                "13579",          // orderNumber
                new Date(),       // orderDate
                Arrays.asList(
                        new OrderItem(4L, "Product D", new BigDecimal("15.00"), 2),
                        new OrderItem(5L, "Product E", new BigDecimal("10.00"), 5)
                ), // orderItems
                new BigDecimal("70.00"), // totalAmount
                "789 Oak Rd, Yet Another City, Yet Another Country", // shippingAddress
                "Debit Card",     // paymentMethod
                OrderStatus.SHIPPED // status
        ));

        orders.add(new Order(
                4L,               // id
                "24680",          // orderNumber
                new Date(),       // orderDate
                Arrays.asList(
                        new OrderItem(6L, "Product F", new BigDecimal("40.00"), 1)
                ), // orderItems
                new BigDecimal("40.00"), // totalAmount
                "101 Pine Ln, Townsville, Countryland", // shippingAddress
                "Bank Transfer",  // paymentMethod
                OrderStatus.DELIVERED // status
        ));

        orders.add(new Order(
                5L,               // id
                "98765",          // orderNumber
                new Date(),       // orderDate
                Arrays.asList(
                        new OrderItem(7L, "Product G", new BigDecimal("5.00"), 3),
                        new OrderItem(8L, "Product H", new BigDecimal("10.00"), 2)
                ), // orderItems
                new BigDecimal("35.00"), // totalAmount
                "555 Beach Blvd, Seaside City, Coastal Country", // shippingAddress
                "Cash on Delivery", // paymentMethod
                OrderStatus.CANCELED // status
        ));
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
