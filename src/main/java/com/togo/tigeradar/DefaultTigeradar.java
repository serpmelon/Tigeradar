package com.togo.tigeradar;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DefaultTigeradar extends AbstractTigeradar {

	@Override
	CloseableHttpClient getHttpClient() {

		return HttpClients.createDefault();
	}

}
