package com.togo.tigeradar;

import org.apache.http.HttpResponse;

import com.togo.tigeradar.context.TigerBeanContext;

public class TestPool implements Runnable {

	private int i;
	public TestPool(int i) {
		
		this.i = i;
	}
	@Override
	public void run() {

		Tigeradar tiger = TigerBeanContext.INSTANCE.getBean("poolTigeradar", Tigeradar.class);
		HttpResponse resp = tiger.get("http://www.hbzwfw.gov.cn/hbjis/gateway/interface.do");
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(tiger.test());
	}

}
