package weiskopf.paint;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import weiskopf.paint.message.PaintMessage;
import weiskopf.paint.message.PaintMessageFactory;

public class ListeningThread extends Thread {

	private Socket socket;
	private Canvas canvas;

	public ListeningThread(Socket socket, Canvas canvas) {
		this.socket = socket;
		this.canvas = canvas;
	}

	@Override
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				PaintMessageFactory factory = new PaintMessageFactory(canvas);
				PaintMessage paintMessage = factory.getMessage(line);
				if (paintMessage != null) {
					paintMessage.apply((Graphics2D) canvas.getImage().getGraphics());
					canvas.incrementCounter();
					canvas.repaint();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
