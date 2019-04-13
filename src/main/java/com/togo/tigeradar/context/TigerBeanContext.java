package com.togo.tigeradar.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public enum TigerBeanContext {

	INSTANCE;

	private ApplicationContext ac;

	private TigerBeanContext() {

		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		if (ac == null)
			throw new NullPointerException("ac is null");
	}

	public Object getBean(String beanId) {

		return ac.getBean(beanId);
	}

	public <T> T getBean(String beanId, Class<T> klass) {

		return ac.getBean(beanId, klass);
	}
}
