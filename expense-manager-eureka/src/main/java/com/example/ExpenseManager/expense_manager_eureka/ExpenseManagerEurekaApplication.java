package com.example.ExpenseManager.expense_manager_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ExpenseManagerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerEurekaApplication.class, args);
	}

}
