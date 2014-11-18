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

		DetailsPanel panel = new DetailsPanel(canvas);
		add(panel, BorderLayout.SOUTH);

		DrawListener dl = new DrawListener(canvas, panel);
		canvas.addMouseMotionListener(dl);
		canvas.addMouseWheelListener(dl);

	}

	public static void main(String[] args) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
