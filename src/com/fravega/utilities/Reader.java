package com.fravega.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reader {
	
	private static File archivo;
	private static Properties properties;
	
	public static Properties propertiesFile(String filePathName) {
		archivo = new File(filePathName);
		properties = new Properties();
		
		FileInputStream fileInput = null;
		
		try {
			fileInput = new FileInputStream(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

}
