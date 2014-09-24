package weiskopf.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Thread{
	
	private ChatWindow window;
	
	public ChatServer(ChatWindow window) throws IOException{
		this.window = window;
		
	}
	
	@Override
	public void run(){
		ServerSocket server;
		try {
			server = new ServerSocket(8080);
			
			while(true){
				Socket socket = server.accept();
				ReceivingThread thread = new ReceivingThread(socket, window);
				thread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
