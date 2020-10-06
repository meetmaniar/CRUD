package com.rmaj.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rmaj.product.util.ProductFeed;

@RestController
public class ProductController {
	
	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET, produces = "text/plain")
	public String helloWorld() {
		ProductFeed.generateFeed("");
		return "Hello World";
	}

}
