package weiskopf.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Paint extends JFrame {

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);

		ColorPanel colors = new ColorPanel();
		add(colors, BorderLayout.EAST);

		DrawListener listener = new DrawListener(canvas);

		canvas.addMouseMotionListener(listener);
	}

	public static void main(String[] args) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
