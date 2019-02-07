package com.togo.tigeradar;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Component;

@Component("poolTigeradar")
public class PoolTigeradar extends AbstractTigeradar {

	@Override
	CloseableHttpClient getHttpClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String test() {
		return "pool";
	}
}
