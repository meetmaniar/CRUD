package com.rmaj.product.configuration;


import java.util.Collections;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableAutoConfiguration
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.rmaj.product.controller"))
				.build()
				.apiInfo(apiInfo());
				
	}
	
	private ApiInfo apiInfo() {
		String version = "1.0";
		
		return new ApiInfo(
				"Feed Generator",
				"This service generates the feed",
				version,
				"",
				new Contact("Meet Maniar", null, "contact@meetmaniar.tech"),
				"All Rights Reserved",
				"http://meetmaniat.tech", Collections.emptyList()
				);
	}
}
