package com.togo.tigeradar;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.springframework.stereotype.Component;

@Component("defaultTigeradar")
public class DefaultTigeradar extends AbstractTigeradar {

	@Override
	CloseableHttpClient getHttpClient() {

		return HttpClients.createDefault();
	}

	@Override
	public String test() {
		return "default";
	}

	@Override
	public String state() {
		// TODO
		return null;
	}
}
