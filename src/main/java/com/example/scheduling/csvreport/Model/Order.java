package com.example.scheduling.csvreport.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private String orderNumber;
    private Date orderDate;
    private List<OrderItem> orderItems;
    private BigDecimal totalAmount;
    private String shippingAddress;
    private String paymentMethod;
    private OrderStatus status;

}
