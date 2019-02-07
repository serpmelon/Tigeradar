package com.togo.tigeradar.conf;

import org.springframework.beans.factory.annotation.Value;

import com.togo.tigeradar.util.PropertiesReader;

public enum PoolTigeradarConfig {

	INSTANCE;

	private int connectTimeout;
	private int connectionRequestTimeout;
	private int socketTimeout;
	private boolean expectContinueEnabled;
	private int maxTotal;
	private int defaultMaxPreRoute;
	
	private final static String POOL_CONFIG_FILE = "poolTigeradarConf.properties";

	private PoolTigeradarConfig() {

		PropertiesReader reader = new PropertiesReader(POOL_CONFIG_FILE);
	}
}
