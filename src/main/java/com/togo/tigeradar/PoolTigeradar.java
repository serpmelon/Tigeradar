package com.togo.tigeradar;

import java.util.concurrent.TimeUnit;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.togo.tigeradar.conf.PoolTigeradarConfig;

@Component("poolTigeradar")
public class PoolTigeradar extends AbstractTigeradar {

	private Logger logger = LoggerFactory.getLogger(PoolTigeradar.class);

	private PoolTigeradar() {
	}

	private PoolingHttpClientConnectionManager pccm;

	@Autowired
	private HttpRequestRetryHandler retryHandler;

	private CloseableHttpClient client;
	/**
	 * 请求配置
	 */
	// TODO
	private RequestConfig params;

	@Autowired
	private PoolTigeradarConfig poolConfig;

	public CloseableHttpClient createHttpClient(String host, int port) {

		// httpclient连接池管理器
		pccm = new PoolingHttpClientConnectionManager();
		// 设置连接参数
		pccm.setMaxTotal(poolConfig.getMaxTotal()); // 最大连接数
		pccm.setDefaultMaxPerRoute(poolConfig.getMaxTotal()); // 路由最大连接数

		HttpHost httpHost = new HttpHost(host, port);
		pccm.setMaxPerRoute(new HttpRoute(httpHost), poolConfig.getMaxTotal());
		pccm.closeIdleConnections(10, TimeUnit.SECONDS);

		CloseableHttpClient newClient = HttpClients.custom().setConnectionManager(pccm)
				.setUserAgent("Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0)")
				.setRetryHandler(retryHandler) // 重试策略
				.setKeepAliveStrategy((response, context) -> 2 * 1000).build();

		logger.info("pool state : {}", pccm.getTotalStats());

		return newClient;
	}

	@Override
	CloseableHttpClient getHttpClient() {

		if (client != null)
			return client;

		synchronized (this) {
			if (client == null) {

				logger.info("create client");
				client = createHttpClient(poolConfig.getHost(), poolConfig.getPort());
			}
		}

		return client;
	}

	/**
	 * 
	 * <p>
	 * Method ：logState
	 * <p>
	 * Description :这样好像不太好，等会改
	 *
	 * @param logger
	 * @see com.togo.tigeradar.Tigeradar#logState(org.slf4j.Logger)
	 */
	@Override
	public String state() {

		return pccm.getTotalStats().toString();
	}

	@Override
	public String test() {
		return pccm.getTotalStats().toString();
	}

	@Override
	protected void closeMethod(HttpRequestBase method) {
		super.closeMethod(method);
		if (method != null)
			method.releaseConnection();
		else
			throw new NullPointerException(method + " methodd is null");
	}

}
