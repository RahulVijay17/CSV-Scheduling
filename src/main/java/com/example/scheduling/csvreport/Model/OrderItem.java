package com.example.scheduling.csvreport.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private Long id;
    private String productName;
    private BigDecimal unitPrice;
    private int quantity;
}