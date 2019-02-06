package com.togo.tigeradar;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class DefaultTigeradar extends AbstractTigeradar {

	@Override
	HttpClient getHttpClient() {

		return HttpClients.createDefault();
	}

}
