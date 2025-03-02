package com.ecommerce.reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Reviews {

	public static void main(String[] args) {
		SpringApplication.run(Reviews.class, args);
	}

}
