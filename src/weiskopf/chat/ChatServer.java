package weiskopf.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(8080);
		ChatBox chatBox = new ChatBox();

		while (true) {
			Socket socket = serverSocket.accept();

			ServerThread thread = new ServerThread(socket, chatBox);
			thread.start();

		}

	}
}
