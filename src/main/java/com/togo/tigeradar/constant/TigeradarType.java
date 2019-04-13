package com.togo.tigeradar.constant;

/**
 * 
 * <p>
 * Class : com.togo.tigeradar.constant.TigeradarType
 * <p>
 * Descdription: tigeradar类型；
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月7日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public enum TigeradarType {

	DEFAULT("defaultTigeradar"), // 默认http请求实现
	POOL("poolTigeradar"); // 连接池http请求实现

	private String beanId;

	private TigeradarType(String id) {

		this.beanId = id;
	}

	public String getType() {

		return beanId;
	}
}
