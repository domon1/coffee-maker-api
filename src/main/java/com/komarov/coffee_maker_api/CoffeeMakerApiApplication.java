package com.komarov.coffee_maker_api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RequiredArgsConstructor
public class CoffeeMakerApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoffeeMakerApiApplication.class, args);
	}
}
