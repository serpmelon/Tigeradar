package com.togo.tigeradar.constant;

import java.util.HashMap;
import java.util.Map;

import com.togo.tigeradar.DefaultTigeradar;
import com.togo.tigeradar.PoolTigeradar;
import com.togo.tigeradar.constant.entity.TigeradarInfo;

/**
 * 
 * <p>
 * Class : com.togo.tigeradar.constant.TigeradarTypeList
 * <p>
 * Descdription:记录当前可用的tigeradar类型；后面可以优化为使用配置文件管理，提供可扩展性
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
public final class TigeradarTypeList {

	private static final String DEFAULT_TIGERADAR = "defaultTigeradar";
	private static final String POOL_TIGERADAR = "poolTigeradar";

	private static Map<TigeradarType, TigeradarInfo> map = new HashMap<>();
	static {

		map.put(TigeradarType.DEFAULT,
				new TigeradarInfo(DEFAULT_TIGERADAR, DefaultTigeradar.class));
		map.put(TigeradarType.POOL, new TigeradarInfo(POOL_TIGERADAR, PoolTigeradar.class));
	}

	private TigeradarTypeList() {
	}

	public static TigeradarInfo getClass(TigeradarType type) {

		TigeradarInfo info = map.get(type);
		if (info == null)
			throw new NullPointerException(type + " has not be supported! 还不支持");

		return info;
	}
}
