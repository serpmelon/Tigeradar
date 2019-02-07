package com.togo.tigeradar.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	private Properties pp = new Properties();
	
	public PropertiesReader(String fileName) {
		InputStream in = PropertiesReader.class.getClassLoader()
				.getResourceAsStream(fileName);
		try {
			pp.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readString(String key) throws IOException {

		return pp.getProperty(key);
	}
}
