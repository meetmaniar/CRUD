package com.rmaj.product.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmaj.product.util.ProductFeed;

@RestController
public class ProductController {
	ClassLoader classLoader = getClass().getClassLoader();
	File schemaFile = new File(classLoader.getResource("productSchema.json").getFile());
	Path schemaPath = Paths.get(schemaFile.toURI());
	String schemaContent = getSchemaContent();
	
	@RequestMapping(value = "/addProductContent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloWorld(@RequestBody String productPost) {
		ProductFeed.generateFeed("productPost");	
		return schemaContent;
	}
	private String getSchemaContent() {
		
		try {
			String schemaContent = Files.readString(schemaPath);
			System.out.println("*****************************");
			System.out.println(schemaContent);
			System.out.println("*****************************");
			return schemaContent;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
