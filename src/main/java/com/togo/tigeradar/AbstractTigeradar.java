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
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTigeradar implements Tigeradar {

	private Logger logger = LoggerFactory.getLogger(AbstractTigeradar.class);

	abstract CloseableHttpClient getHttpClient();

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
	public CloseableHttpResponse post(String url) {

		HttpPost httpPost = new HttpPost(url);

		return doPost(httpPost);
	}

	@Override
	public CloseableHttpResponse post(String url, List<NameValuePair> params) {
		HttpPost httpPost = new HttpPost(url);// 创建httpPost
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doPost(httpPost);
	}

	@Override
	public CloseableHttpResponse post(String url, Map<String, String> params) {

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
			response = client.execute(httpGet);
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// if(client != null) {
			// client.close();
			// }
		}

		return response;
	}

	private CloseableHttpResponse doPost(HttpPost post) {

		CloseableHttpClient httpClient = getHttpClient();
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		try {

			// post.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(post);
			entity = response.getEntity();
			// responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// try {
			// // 关闭连接,释放资源
			// if (response != null) {
			// response.close();
			// }
			// if (httpClient != null) {
			// httpClient.close();
			// }
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
		}
		return response;
	}

	// TODO 构建请求头

}
