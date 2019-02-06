package com.togo.tigeradar;

import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

/**
 * 
 * <p>
 * Class : com.togo.tigeradar.Tigeradar
 * <p>
 * Descdription: http 请求工具；定义了基础的get post方法
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月5日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public interface Tigeradar {

	HttpResponse get(String url);

	HttpResponse get(String url, Map<String, String> params);

	/**
	 * 
	 * <p>
	 * Method ：post
	 * <p>
	 * Description : post无参数方法；不建议使用，post方法表示增加肯定是有参数的
	 *
	 * @param url
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月6日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	HttpResponse post(String url);

	HttpResponse post(String url, List<NameValuePair> params);
}
