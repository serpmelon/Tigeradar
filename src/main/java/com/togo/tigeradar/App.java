package com.togo.tigeradar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		App app = new App();
		app.server();
	}

	public void server() throws Exception {
		ServerSocket serverSocket = new ServerSocket(80);
		Socket socket = serverSocket.accept();
		
		StringBuffer error = new StringBuffer();
		error.append("HTTP /1.1 404 file not found /r/n");
		error.append("Content-Type:text/html \r\n");
		error.append("Content-Length:20 \r\n").append("\r\n");
		error.append("<h1 >File Not Found..</h1>");
		
		OutputStream out = socket.getOutputStream();
		try {
			out.write(error.toString().getBytes());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
