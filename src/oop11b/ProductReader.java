package oop11b;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProductReader {
	// simple factory pattern을 구조안에서 설정값을 읽기 위한 책임을 분리해낸 유틸리티 클래스
	private static Properties props = new Properties();

	static {
		try {
			props.load(new FileInputStream("src/oop11b/product.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}
}
