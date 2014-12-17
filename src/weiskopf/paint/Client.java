package weiskopf.paint;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.107", 3773);
	}

	public void sendMessage(String message) throws IOException {
		OutputStream output = socket.getOutputStream();
		output.write(message.toString().getBytes());
		output.flush();
	}

}
