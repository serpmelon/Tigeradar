package com.togo.tigeradar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DefaultTigeradarTest {

	@Test
	public void testGet() {

		System.setProperty("log.base", "C:/Users/Administrator/Desktop");

		Tigeradar tigeradar = new DefaultTigeradar();

		String url = "https://www.baidu.com";
		assertEquals(300, tigeradar.get(url).getStatusLine().getStatusCode());
//		System.out.println(tigeradar.get(url).getStatusLine().getStatusCode());
	}
}
