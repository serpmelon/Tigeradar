package com.togo.tigeradar.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.togo.tigeradar.constant.TigeradarType;
import com.togo.tigeradar.constant.TigeradarTypeList;
import com.togo.tigeradar.constant.entity.TigeradarInfo;

public enum TigerBeanContext {

	INSTANCE;

	private ApplicationContext ac;

	private TigerBeanContext() {

		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public Object getBean(String beanId) {

		return ac.getBean(beanId);
	}

	public <T> T getBean(String beanId, Class<T> klass) {

		return ac.getBean(beanId, klass);
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(TigeradarType type) {

		TigeradarInfo info = TigeradarTypeList.getClass(type);

		return (T) getBean(info.getBeanId(), info.getKlass());
	}
}
