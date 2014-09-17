package weiskopf.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {

	public static void main(String[] args) throws IOException {
		
		//ServerSocket is a socket that listens
		ServerSocket serverSocket = new ServerSocket(8080);//ip is myself, use port 8080 - standard port for listening
		Socket socket = serverSocket.accept();//this is how you listen, when someone connects to you a socket is returned
		
		InputStream in = socket.getInputStream();//read from the socket
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String html;
		while((html = reader.readLine()) != null){
			System.out.println(html);
		}
		
		OutputStream out = socket.getOutputStream();
		out.write("Hello World!".getBytes());
		out.flush();
		out.close();
		
		//program returns the actual request that the browser sends to the web servers it connects to
		serverSocket.close();
	}

}
