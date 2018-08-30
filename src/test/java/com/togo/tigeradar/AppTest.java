package com.togo.tigeradar;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {


	public void server() throws Exception {
		ServerSocket serverSocket = new ServerSocket(80);
		Socket socket = serverSocket.accept();
		InputStream stream = socket.getInputStream();
		int r = -1;
		while ((r = stream.read()) != -1) {
			System.out.print((char) r);
		}
	}
}
