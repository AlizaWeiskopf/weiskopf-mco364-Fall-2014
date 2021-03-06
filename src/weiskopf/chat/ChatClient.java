package weiskopf.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	public ChatClient(String chatText) throws UnknownHostException, IOException {
		//Socket socket = new Socket("192.168.117.137", 8080);
		Socket socket = new Socket("localhost", 8080);
		OutputStream output = socket.getOutputStream();
		output.write(chatText.getBytes());
		output.flush();
		socket.close();
	}

}
