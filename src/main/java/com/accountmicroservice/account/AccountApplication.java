package com.accountmicroservice.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication {

	private static final Logger logger = LoggerFactory.getLogger(AccountApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);

		logger.info("Esto es un Info");
		logger.warn("Esto es warn");
		logger.error("Esto es un error");

	}

}
