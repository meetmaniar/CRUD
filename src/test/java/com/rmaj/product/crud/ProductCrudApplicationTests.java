package com.rmaj.product.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication
class ProductCrudApplicationTests {

	@Test
	void contextLoads() {
		assertEquals(11, 11);
	}

}