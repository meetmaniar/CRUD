package com.rmaj.product.controller;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmaj.product.util.ProductFeed;

@RestController
public class ProductController {	
	@Autowired
	Schema schema;
	
	@RequestMapping(value = "/addProductContent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String helloWorld(@RequestBody String productPost) {
		JSONObject returnStatusInJSON;
		try {
			schema.validate(new JSONObject(productPost));
			ProductFeed.generateFeed(productPost);
			returnStatusInJSON = new JSONObject("{'status' : 'success'}");
		} catch (ValidationException e) {
			e.printStackTrace();
			returnStatusInJSON = new JSONObject("{'status' : 'fail'}");
		}
		return returnStatusInJSON.toString();
	}
	
	@RequestMapping(value="/helloworld", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String testHello() {
		JSONObject returnStatement;
		returnStatement = new JSONObject("{'Tests /helloworld' : 'success'}");
		return returnStatement.toString();	
		
	}
}
