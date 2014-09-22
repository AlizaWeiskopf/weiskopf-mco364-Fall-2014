package weiskopf.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;
	private int counter;

	public ServerThread(Socket s, int counter) {
		this.socket = s;
		this.counter = counter;
	}

	@Override
	public void run() {

		try {
			InputStream in = socket.getInputStream();// read from the socket
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String html;
			while (!"".equals((html = reader.readLine()))) {
				System.out.println(html);
			}

			OutputStream out = socket.getOutputStream();
			String response = "<h2>This is the " + counter + " request</h2>";
			out.write("HTTP/1.1 200 OK\n".getBytes());
			out.write("Content-Type: text/html; charset=utf-8\n".getBytes());
			out.write((("Content-Length: " + response.length() + "\n\n").getBytes()));
			out.write(response.getBytes());
			out.flush();
			out.close();
		} catch (IOException ex) {
			ex.getStackTrace();
		}
	}

}
