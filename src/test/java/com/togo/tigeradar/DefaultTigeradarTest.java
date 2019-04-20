package com.togo.tigeradar;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpResponse;
import org.junit.Test;

import com.togo.tigeradar.constant.TigeradarType;
import com.togo.tigeradar.context.TigerBeanContext;

/**
 * Unit test for simple App.
 */
public class DefaultTigeradarTest {

	@Test
	public void testGet() {

		System.setProperty("log.base", "C:/Users/AI/Desktop");

		Tigeradar tigeradar = TigerBeanContext.INSTANCE.getBean(TigeradarType.DEFAULT);

		String url = "https://www.baidu.com";
		HttpResponse resp = tigeradar.get(url);
		assertEquals(200, resp.getStatusLine().getStatusCode());
		// System.out.println(tigeradar.get(url).getStatusLine().getStatusCode());
	}
}
