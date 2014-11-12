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

		ChooseColorPanel colors = new ChooseColorPanel(canvas);
		add(colors, BorderLayout.SOUTH);

		canvas.addMouseMotionListener(new DrawListener(canvas));

	}

	public static void main(String[] args) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
