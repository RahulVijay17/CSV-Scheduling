package com.example.scheduling.csvreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CsvreportApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvreportApplication.class, args);
	}

}
