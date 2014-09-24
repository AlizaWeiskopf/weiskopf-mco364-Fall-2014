package weiskopf.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceivingThread extends Thread{
	
	private Socket socket;
	private ChatWindow window;
	
	public ReceivingThread(Socket socket, ChatWindow window){
		this.socket = socket;
		this.window = window;
	}
	
	@Override
	public void run(){
		try {
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while((line = reader.readLine()) != null){
				window.setChatHistoryText(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
