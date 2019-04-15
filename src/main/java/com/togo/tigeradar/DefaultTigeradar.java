package com.togo.tigeradar;

import java.io.IOException;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.springframework.stereotype.Component;

@Component("defaultTigeradar")
public class DefaultTigeradar extends AbstractTigeradar {

	private DefaultTigeradar() {
	}

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
		return null;
	}

	@Override
	protected void closeClient(CloseableHttpClient client) {
		super.closeClient(client);

		try {
			if (client != null)
				client.close();
			else
				throw new NullPointerException(
						"CLIENT IS NULL WHEN LAUNCHED THE 'closeClient' METHOD");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
