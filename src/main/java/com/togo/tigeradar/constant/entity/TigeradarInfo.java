package com.togo.tigeradar.constant.entity;

import com.togo.tigeradar.Tigeradar;

/**
 * 
 * <p>
 * Class : com.togo.tigeradar.constant.entity.TigeradarInfo
 * <p>
 * Descdription:用于描述一种tigeradar
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年4月15日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class TigeradarInfo {

	private String beanId;
	private Class<? extends Tigeradar> klass;

	public TigeradarInfo(String beanId, Class<? extends Tigeradar> klass) {

		this.beanId = beanId;
		this.klass = klass;
	}

	public String getBeanId() {
		return beanId;
	}

	public Class<? extends Tigeradar> getKlass() {
		return klass;
	}
}
