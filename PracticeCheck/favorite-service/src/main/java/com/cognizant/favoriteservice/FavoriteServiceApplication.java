package com.cognizant.favoriteservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.cognizant.ExchangeServiceProxy")
public class FavoriteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoriteServiceApplication.class, args);
	}

}
