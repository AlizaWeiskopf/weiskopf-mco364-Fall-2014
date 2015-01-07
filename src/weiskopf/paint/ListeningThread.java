package weiskopf.paint;

import java.awt.Graphics2D;
import java.io.BufferedReader;
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
		// thread dies if exception is thrown - so won't receive any
		// messages if this happens
		try {
			PaintMessageFactory factory = new PaintMessageFactory(canvas);
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {

				try {
					PaintMessage paintMessage = factory.getMessage(line);
					if (paintMessage != null) {
						paintMessage.apply((Graphics2D) canvas.getImage().getGraphics());
						canvas.incrementCounter();
						canvas.repaint();
					}
				} catch (Exception e) {
					e.printStackTrace();
					// if catch exception thread won't die

					// do continue to go back to while loop, otherwise may not
					// die
					// but won't go back to top - now want to just avoid this
					// message and continue
					continue;
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
