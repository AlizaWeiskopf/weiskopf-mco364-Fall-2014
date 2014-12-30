package weiskopf.paint;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;

	public Client(Canvas canvas) throws UnknownHostException, IOException {
		socket = new Socket("192.168.1.2", 3773);

		ListeningThread thread = new ListeningThread(socket, canvas);
		thread.start();
	}

	public void sendMessage(String message) throws IOException {
		OutputStream output = socket.getOutputStream();
		output.write(message.toString().getBytes());
		output.flush();
	}

}
