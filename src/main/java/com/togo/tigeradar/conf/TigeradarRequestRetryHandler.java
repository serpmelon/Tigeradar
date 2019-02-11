package com.togo.tigeradar.conf;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>
 * Class : com.togo.tigeradar.conf.TigeradarRequestRetryHandler
 * <p>
 * Descdription:请求重试策略
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月11日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */

@Component
public class TigeradarRequestRetryHandler implements HttpRequestRetryHandler {

	private Logger logger = LoggerFactory.getLogger(TigeradarRequestRetryHandler.class);

	@Override
	public boolean retryRequest(IOException exception, int executionCount,
			HttpContext httpContext) {

		if (executionCount > 3) {
			// 重试超过3次,放弃请求
			logger.error("retry has more than 3 time, give up request");
			return false;
		}
		if (exception instanceof NoHttpResponseException) {
			// 服务器没有响应,可能是服务器断开了连接,应该重试
			logger.error("receive no response from server, retry");
			return true;
		}
		if (exception instanceof SSLHandshakeException) {
			// SSL握手异常
			logger.error("SSL hand shake exception");
			return false;
		}
		if (exception instanceof InterruptedIOException) {
			// 超时
			logger.error("InterruptedIOException");
			return false;
		}
		if (exception instanceof UnknownHostException) {
			// 服务器不可达
			logger.error("server host unknown");
			return false;
		}
		if (exception instanceof ConnectTimeoutException) {
			// 连接超时
			logger.error("Connection Time out");
			return false;
		}
		if (exception instanceof SSLException) {
			logger.error("SSLException");
			return false;
		}

		HttpClientContext context = HttpClientContext.adapt(httpContext);
		HttpRequest request = context.getRequest();

		if (!(request instanceof HttpEntityEnclosingRequest)) {
			// 如果请求不是关闭连接的请求
			return true;
		}

		return false;
	}

}
