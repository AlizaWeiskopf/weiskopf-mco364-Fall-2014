package weiskopf.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkRequest {
	
	//how to read and write data from a socket
	//connect to other computers/servers without URLs
	
	public static void main (String[]args) throws IOException{
		
		Socket socket = new Socket("www.amazon.com", 80);//ip address, port
		InputStream in = socket.getInputStream();//reads info from the socket (amazon's server)
		OutputStream out = socket.getOutputStream();//send data to a server
		String request = "GET /index.html\n\n";//part of http protocol
		out.write(request.getBytes());//sends request to server
		out.flush();//this actually sends the data out
		
		//web server will send us back the html of the page we asked for
		//not easy to read a string from an InputStream so use a BufferedReader - that has a method readLine
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String html;
		while((html = reader.readLine()) != null){
			System.out.println(html);
		}
		
		socket.close();
		
		
	}

}
