package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class FileReaderManager {
	private static FileInputStream fileinputstream;
	private static Properties properties;
	public static void setProperty() {
		File file = new File("C:\\Users\\kESAVAN\\eclipse-workspace\\Naukriproject\\src\\main\\resources\\TestData1.properties");
		try {
			fileinputstream = new FileInputStream(file);
			properties = new Properties();
			try {
				properties.load(fileinputstream);
			} catch (IOException e) {
				Assert.fail("Error occurred while file reading");
			}
		} catch (FileNotFoundException e) {
			Assert.fail("Error occurred while locating file");
		}
	}
	public static String getProperty(String Key) {
		setProperty();
		String value = properties.getProperty(Key);
		return value;
		
	}
	public static void main(String[] args) {
		System.out.println(getProperty("browser"));
	}
}