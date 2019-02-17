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

	/**
	 * 
	 * <p>
	 * Method ：get
	 * <p>
	 * Description :get请求
	 *
	 * @param url
	 *            请求的路径
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月6日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	HttpResponse get(String url);

	/**
	 * 
	 * <p>
	 * Method ：get
	 * <p>
	 * Description :
	 *
	 * @param url
	 *            请求路径
	 * @param params
	 *            请求参数
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月6日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
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

	/**
	 * 
	 * <p>
	 * Method ：post
	 * <p>
	 * Description :看名字应该都懂
	 *
	 * @param url
	 * @param params
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月6日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	HttpResponse post(String url, List<NameValuePair> params);

	/**
	 * 
	 * <p>
	 * Method ：post
	 * <p>
	 * Description :看名字应该都懂
	 *
	 * @param url
	 * @param params
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月6日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	HttpResponse post(String url, Map<String, String> params);

	String state();

	String test();
}
