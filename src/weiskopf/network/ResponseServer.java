package weiskopf.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {

	public static void main(String[] args) throws IOException, InterruptedException {

		// ServerSocket is a socket that listens
		ServerSocket serverSocket = new ServerSocket(8080);// ip is myself, use
															// port 8080 -
															// standard port for
															// listening
		int counter = 0;
		while (true) {

			Socket socket = serverSocket.accept();// this is how you listen,
													// when someone connects to
													// you a socket is returned

			ServerThread thread = new ServerThread(socket, counter);
			thread.start();

			counter++;

			// program returns the actual request that the browser sends to the
			// web servers it connects to
		}
	}
}
