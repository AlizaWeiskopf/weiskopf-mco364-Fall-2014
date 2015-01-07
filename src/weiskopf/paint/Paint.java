package weiskopf.paint;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class Paint extends JFrame {

	public Paint() throws UnknownHostException, IOException {
		setTitle("Paint");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Canvas canvas = new Canvas(this);
		add(canvas, BorderLayout.CENTER);

	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
