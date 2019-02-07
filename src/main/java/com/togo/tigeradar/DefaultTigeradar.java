package com.togo.tigeradar;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("defaultTigeradar")
public class DefaultTigeradar extends AbstractTigeradar {

	@Autowired
	private Test tt;
	
	@Override
	CloseableHttpClient getHttpClient() {

		return HttpClients.createDefault();
	}

	@Override
	public String test() {
		tt.print();
		return "default";
	}

}
