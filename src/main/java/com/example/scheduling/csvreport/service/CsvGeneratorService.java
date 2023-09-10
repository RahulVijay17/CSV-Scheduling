package com.example.scheduling.csvreport.service;

import com.example.scheduling.csvreport.Model.Order;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CsvGeneratorService {

    public void generateCsvReport(List<Order> orders, String csvFilePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            // Define the CSV header
            String[] header = {
                    "ID", "Order Number", "Order Date", "Total Amount",
                    "Shipping Address", "Payment Method", "Status",
                    "Order Item ID", "Product Name", "Unit Price", "Quantity"
            };
            writer.writeNext(header);

            // Write order and order item data to CSV
            orders.stream().forEach(order -> {
                order.getOrderItems().stream().forEach(item -> {
                    String[] data = {
                            order.getId().toString(),
                            order.getOrderNumber(),
                            order.getOrderDate().toString(),
                            order.getTotalAmount().toString(),
                            order.getShippingAddress(),
                            order.getPaymentMethod(),
                            order.getStatus().toString(),
                            item.getId().toString(),
                            item.getProductName(),
                            item.getUnitPrice().toString(),
                            String.valueOf(item.getQuantity())
                    };
                    writer.writeNext(data);
                });
            });
        }
    }
}