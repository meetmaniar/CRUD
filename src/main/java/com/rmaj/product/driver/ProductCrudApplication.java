package com.rmaj.product.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.rmaj.product.controller"})
@ComponentScan(basePackages={"com.rmaj.product.configuration"})
@ComponentScan(basePackages={"com.rmaj.product.util"})

public class ProductCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCrudApplication.class, args);

	}

}
