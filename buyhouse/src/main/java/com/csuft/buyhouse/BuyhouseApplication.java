package com.csuft.buyhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.csuft.buyhouse"})
public class BuyhouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyhouseApplication.class, args);
	}

}
