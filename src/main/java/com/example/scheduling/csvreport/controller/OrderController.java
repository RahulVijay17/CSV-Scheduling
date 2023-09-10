package com.example.scheduling.csvreport.controller;

import com.example.scheduling.csvreport.Model.Order;
import com.example.scheduling.csvreport.service.CsvGeneratorService;
import com.example.scheduling.csvreport.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private CsvGeneratorService csvGeneratorService;


    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/generate-csv-report")
    @Scheduled(cron = "0/30 * * * * *") // 30 seconds (30,000 milliseconds)
    public String generateCsvReport() {
        try {
            List<Order> orders = orderService.getAllOrders();

            // Specify the directory where you want to store the CSV files
            String directoryPath = "C:\\Users\\HP\\OneDrive\\Desktop\\EazyBytes Microservice\\";

            // Generate a unique CSV file name based on the timestamp
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String csvFileName =directoryPath+ "orders_report_" + timestamp + ".csv";


            csvGeneratorService.generateCsvReport(orders, csvFileName);

            return "CSV report generated successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error generating CSV report";
        }
    }
}