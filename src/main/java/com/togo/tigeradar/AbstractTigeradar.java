package com.togo.tigeradar;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>
 * Class : com.togo.tigeradar.AbstractTigeradar
 * <p>
 * Descdription: tigeradar的抽象实现类，基本实现了请求方法
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
public abstract class AbstractTigeradar implements Tigeradar {

	private Logger logger = LoggerFactory.getLogger(AbstractTigeradar.class);

	private static RequestConfig requestConfig;

	abstract CloseableHttpClient getHttpClient();

	static {
		initializeRequestConfig();
	}

	@Override
	public HttpResponse get(String url) {

		HttpResponse response = null;
		URIBuilder uriBuilder;
		try {
			uriBuilder = new URIBuilder(url);
			response = doGet(uriBuilder.build());
		} catch (URISyntaxException e) {
			logger.error("", e);
		}
		return response;
	}

	@Override
	public HttpResponse get(String url, Map<String, String> params) {

		HttpResponse response = null;
		URIBuilder uriBuilder;
		try {
			uriBuilder = new URIBuilder(url);

			List<NameValuePair> list = new LinkedList<>();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				BasicNameValuePair param = new BasicNameValuePair(entry.getKey(), entry.getValue());
				list.add(param);
			}

			uriBuilder.setParameters(list);
			response = doGet(uriBuilder.build());
		} catch (URISyntaxException e) {
			logger.error("", e);
		}

		return response;
	}

	@Override
	public HttpResponse post(String url) {

		HttpPost httpPost = new HttpPost(url);

		return doPost(httpPost);
	}

	@Override
	public HttpResponse post(String url, List<NameValuePair> params) {
		HttpPost httpPost = new HttpPost(url);// 创建httpPost
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (Exception e) {
			logger.error("", e);
		}

		return doPost(httpPost);
	}

	@Override
	public HttpResponse post(String url, Map<String, String> params) {

		// 创建参数队列
		List<NameValuePair> nameValuePairs = new ArrayList<>();

		for (Map.Entry<String, String> entry : params.entrySet()) {
			nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}

		return post(url, nameValuePairs);
	}

	private HttpResponse doGet(URI uri) {

		CloseableHttpResponse response = null;
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpClient client = getHttpClient();

		try {
			httpGet.setConfig(requestConfig);
			response = client.execute(httpGet);
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			try {
				if (response != null) {

					response.close();
				}

				if (client != null) {

					client.close();
				}
			} catch (IOException e) {
				logger.error("", e);
			}
		}

		return response;
	}

	private HttpResponse doPost(HttpPost post) {

		CloseableHttpClient client = getHttpClient();
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		try {

			post.setConfig(requestConfig);
			// 执行请求
			response = client.execute(post);
			entity = response.getEntity();
			// responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {

					response.close();
				}

				if (client != null) {

					client.close();
				}
			} catch (IOException e) {
				logger.error("", e);
			}
		}
		return response;
	}

	/**
	 * 
	 * <p>
	 * Method ：initializeRequestConfig
	 * <p>
	 * Description : 初始化RequestConfig
	 * 
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月17日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	private static void initializeRequestConfig() {

		requestConfig = RequestConfig.custom() // RequestConfigBuilder
				.setConnectionRequestTimeout(60000) //
				.setConnectTimeout(60000) //
				.setSocketTimeout(10000) //
				.build();
	}

}
