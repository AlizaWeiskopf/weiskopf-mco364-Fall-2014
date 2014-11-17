package weiskopf.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiChatServer {

	public static void main(String[] args) throws IOException {

		ChatWindow window = new ChatWindow();
		window.setVisible(true);
		ServerSocket serverSocket = new ServerSocket(9097);
		List<Socket> sockets = new ArrayList<Socket>();
		BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
		// LinkedBlockingQueue will block at the take method and wait for there
		// to be something to take
		MessageSender sender = new MessageSender(sockets, messages);

		while (true) {
			Socket socket = serverSocket.accept();
			// need to handle the input socket at this point
			SocketHandler handler = new SocketHandler(socket, messages);
			handler.start();
		}

	}

}
