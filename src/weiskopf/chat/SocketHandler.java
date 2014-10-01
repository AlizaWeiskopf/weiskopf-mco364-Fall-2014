package weiskopf.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class SocketHandler extends Thread {

	private Socket s;
	private BlockingQueue<String> messages;

	public SocketHandler(Socket s, BlockingQueue<String> messages) {
		this.s = s;
		this.messages = messages;
	}

	public void run() {
		try {
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				// at this point send out to all clients
				messages.add(line); // all threads use same List of messages
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
