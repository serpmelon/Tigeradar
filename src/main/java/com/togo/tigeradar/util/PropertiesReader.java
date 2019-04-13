package com.togo.tigeradar.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.util.StringUtils;

import com.togo.tigeradar.exception.PropertyException;

public class PropertiesReader {

	private Properties pp = new Properties();

	public PropertiesReader(String fileName) {
		InputStream in = PropertiesReader.class.getClassLoader().getResourceAsStream(fileName);
		try {
			pp.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String readString(String key) {

		return pp.getProperty(key);
	}

	public int readInt(String key) {

		String value = pp.getProperty(key);

		if (StringUtils.isEmpty(value)) {

			throw new PropertyException("配置文件中没有key对应的value, key:" + key);
		}
		int valInt;
		try {

			valInt = Integer.parseInt(value);
		} catch (NumberFormatException e) {

			throw new PropertyException("配置文件转换错误，String -> int, value: " + value);
		}

		return valInt;
	}

	/**
	 * 
	 * <p>
	 * Method ：readBoolean
	 * <p>
	 * Description :返回boolean类型，如果值不为true，则为false
	 *
	 * @param key
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月9日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public boolean readBoolean(String key) {

		String value = pp.getProperty(key);

		if (StringUtils.isEmpty(value)) {

			throw new PropertyException("配置文件中没有key对应的value, key:" + key);
		}

		return value.equalsIgnoreCase("true");
	}
}
