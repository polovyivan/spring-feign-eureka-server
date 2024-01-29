package com.polovyi.ivan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCustomerApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringCustomerApp.class, args);
	}

}
