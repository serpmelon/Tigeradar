package com.togo.tigeradar;

public class Test {

	public static void main(String[] args) {
		
		System.setProperty("log.base", "C:/Users/Administrator/Desktop");
		
		Tigeradar tigeradar = new DefaultTigeradar();
		
		String url = "https://www.baidu.com";
		System.out.println(tigeradar.get(url).getEntity().toString());
	}
}
