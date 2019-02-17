package com.togo.tigeradar;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpResponse;
import org.junit.Test;

import com.togo.tigeradar.context.TigerBeanContext;

public class PoolTigeradarTest {

	@Test
	public void testPool() {

		// Tigeradar tiger = TigerBeanContext.INSTANCE.getBean("poolTigeradar",
		// Tigeradar.class);
		// assertEquals("pool", tiger.test());
		for (int i = 0; i < 100; i++) {

			Thread t = new Thread(new TestPool(i));
			t.start();
		}
		
		while(true) {}
	}
}
