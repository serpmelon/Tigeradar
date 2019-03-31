package com.togo.tigeradar;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.togo.tigeradar.context.TigerBeanContext;

public class TestPool implements Runnable {

	private int i;
	private Tigeradar ti = TigerBeanContext.INSTANCE.getBean("poolTigeradar", Tigeradar.class);;

	public TestPool(int i) {

		this.i = i;
	}

	@Override
	public void run() {

		Tigeradar tiger1 = TigerBeanContext.INSTANCE.getBean("poolTigeradar", Tigeradar.class);

		HttpResponse resp = tiger1.get("http://www.hbzwfw.gov.cn/hbjis/gateway/interface.do");
		
		try {
			String responseContent = EntityUtils.toString(resp.getEntity(), "UTF-8");
			System.out.println(responseContent);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("NO." + i);
		System.out.println(tiger1.test());

	}

	public Tigeradar getTi() {
		return ti;
	}

	public void setTi(Tigeradar ti) {
		this.ti = ti;
	}

}
