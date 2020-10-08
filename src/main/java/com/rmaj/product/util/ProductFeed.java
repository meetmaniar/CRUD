package com.rmaj.product.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Logger;

import java.util.logging.Level;

public class ProductFeed {
	
	private final static Logger logger = Logger.getLogger(ProductFeed.class.getName());
	public static void generateFeed(String pContent) {
		File feedFile = new File("ProductFeed");
		appendContentToFile(feedFile, pContent);
	}
	
	private static void appendContentToFile(File pFile, String pContent) {
		try {
			if(!pFile.exists()) {
				pFile.createNewFile();
			}
				FileWriter pFileWriter = new FileWriter(pFile,true);
		    	BufferedWriter pBufferedWriter = new BufferedWriter(pFileWriter);
		    	PrintWriter pPrintWriter = new PrintWriter(pBufferedWriter);
				writeContentToFile(pPrintWriter,pContent);
				pBufferedWriter.close();
				pFileWriter.close();
		    	closeOverSizedFile(pFile);
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "******************************************");
			logger.log(Level.SEVERE, "Exception occured in appendContentToFile()");
			e.printStackTrace();
			logger.log(Level.SEVERE, "******************************************");
		}
	}
	
	private static void writeContentToFile(PrintWriter pPrintWriter, String string) {
    	pPrintWriter.println(string);
    	pPrintWriter.close();
	}
	
	private static void closeOverSizedFile(File pFile) {
		long fileSizeInKiloBytes = pFile.length()/1024;
		if(fileSizeInKiloBytes > 1024) {
			logger.log(Level.SEVERE, pFile.getName()+" exceeded 100mbs");
			long nanoTime = System.nanoTime();
			pFile.renameTo(new File(pFile.getAbsoluteFile().toString()+nanoTime));
			logger.log(Level.SEVERE, "Moving to: "+pFile.getAbsolutePath().toString()+nanoTime);
		}
	}

}
