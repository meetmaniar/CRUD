package com.rmaj.product.util;

import java.io.File;
import java.io.IOException;

public class ProductFeed {
	
	
	public static void generateFeed(String s) {
		File file = new File("ProductFeed"+System.nanoTime());
		try {
			file.createNewFile();
			System.out.println("Absolute Path: "+file.getAbsolutePath());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
