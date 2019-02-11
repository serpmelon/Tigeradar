package com.togo.tigeradar.conf;

import org.springframework.stereotype.Component;

import com.togo.tigeradar.util.PropertiesReader;

/**
 * 
 * <p>
 * Class : com.togo.tigeradar.conf.PoolTigeradarConfig
 * <p>
 * Descdription:连接池配置类；对象初始化的时候会初始化配置文件中的设置；
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月9日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
@Component
public class PoolTigeradarConfig {

	private int connectTimeout;
	private int connectionRequestTimeout;
	private int socketTimeout;
	private boolean expectContinueEnabled;
	private int maxTotal;
	private int defaultMaxPreRoute;

	private String host;
	private int port;

	private final static String POOL_CONFIG_FILE = "poolTigeradarConf.properties";

	private final static String POOL_CONNECT_TIMEOUT = "httpclient.pool.connect-timeout";
	private final static String POOL_CONNECT_REQUEST_TIMEOUT = "httpclient.pool.connection-request-timeout";
	private final static String POOL_SOCKET_TIMEOUT = "httpclient.pool.socket-timeout";
	private final static String POOL_EXPECT_CONTINUE_ENABLED = "httpclient.pool.expect-continue-enabled";
	private final static String POOL_MAX_TOTAL = "httpclient.pool.max-total";
	private final static String POOL_DEFAULT_MAX_PRE_ROUTE = "httpclient.pool.default-max-pre-route";

	private final static String POOL_HOST = "httpclient.pool.host";
	private final static String POOL_PORT = "httpclient.pool.port";

	private PropertiesReader reader;

	private PoolTigeradarConfig() {

		reader = new PropertiesReader(POOL_CONFIG_FILE);

		connectTimeout = reader.readInt(POOL_CONNECT_TIMEOUT);
		connectionRequestTimeout = reader.readInt(POOL_CONNECT_REQUEST_TIMEOUT);
		socketTimeout = reader.readInt(POOL_SOCKET_TIMEOUT);
		expectContinueEnabled = reader.readBoolean(POOL_EXPECT_CONTINUE_ENABLED);
		maxTotal = reader.readInt(POOL_MAX_TOTAL);
		defaultMaxPreRoute = reader.readInt(POOL_DEFAULT_MAX_PRE_ROUTE);

		host = reader.readString(POOL_HOST);
		port = reader.readInt(POOL_PORT);
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public int getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public boolean isExpectContinueEnabled() {
		return expectContinueEnabled;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public int getDefaultMaxPreRoute() {
		return defaultMaxPreRoute;
	}

	public static String getPoolConfigFile() {
		return POOL_CONFIG_FILE;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}
}
