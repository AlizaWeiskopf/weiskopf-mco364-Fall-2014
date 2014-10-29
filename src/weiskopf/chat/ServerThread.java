package weiskopf.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;
	private ChatBox window;

	public ServerThread(Socket socket, ChatBox window) {
		this.socket = socket;
		this.window = window;
	}

	@Override
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				window.addClientText(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
