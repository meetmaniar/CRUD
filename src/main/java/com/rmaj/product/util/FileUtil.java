package com.rmaj.product.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
@Service
public class FileUtil {
	ClassLoader classLoader = getClass().getClassLoader();
	File schemaFile = new File(classLoader.getResource("productSchema.json").getFile());
	Path schemaPath = Paths.get(schemaFile.toURI());
	JSONObject schemaContent = new JSONObject(getSchemaContent());
	Schema schema = SchemaLoader.load(schemaContent);
	
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
	
	@Bean
	Schema getSchema() {
		return schema;
	}
}
