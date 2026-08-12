package com.market.efair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EfairApplication {

	public static void main(String[] args) {

		System.out.println("Initializing system");
		SpringApplication.run(EfairApplication.class, args);
	}

}
