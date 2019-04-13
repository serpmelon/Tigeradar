package com.togo.tigeradar;

import org.junit.Test;

public class PoolTigeradarTest {

	@Test
	public void testPool() {

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 2000; i++) {

			TestPool tp = new TestPool(i);
			Thread t = new Thread(tp);
			t.start();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 2000; i < 4000; i++) {

			TestPool tp = new TestPool(i);
			Thread t = new Thread(tp);
			t.start();
		}
		while (true) {
		}
	}
}
