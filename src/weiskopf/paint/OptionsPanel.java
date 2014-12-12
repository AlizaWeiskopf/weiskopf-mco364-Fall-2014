package weiskopf.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel {

	private Canvas canvas;

	private JButton brush;
	private JButton bucketFill;
	private JButton drawRect;
	private JButton fillRect;
	private JButton drawOval;
	private JButton fillOval;
	private JButton drawLine;

	public OptionsPanel(Canvas canvas) {
		this.canvas = canvas;

		brush = new JButton("Brush");
		bucketFill = new JButton("Bucket Fill");
		drawRect = new JButton("Draw Rectangle");
		fillRect = new JButton("Fill Rectangle");
		drawOval = new JButton("Draw Oval");
		fillOval = new JButton("Fill Oval");
		drawLine = new JButton("Draw Line");

		SelectDrawListener drawType = new SelectDrawListener();
		brush.addActionListener(drawType);
		bucketFill.addActionListener(drawType);
		drawRect.addActionListener(drawType);
		fillRect.addActionListener(drawType);
		drawOval.addActionListener(drawType);
		fillOval.addActionListener(drawType);
		drawLine.addActionListener(drawType);

		add(brush);
		add(bucketFill);
		add(drawRect);
		add(fillRect);
		add(drawOval);
		add(fillOval);
		add(drawLine);
	}

	private class SelectDrawListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getText()) {

			case "Brush":
				DrawBrush brush = new DrawBrush(canvas);
				canvas.addDrawListener(brush);
				break;
				
			case "Bucket Fill":
				DrawBucketFill bucketFill = new DrawBucketFill(canvas);
				canvas.addDrawListener(bucketFill);
				break;

			case "Draw Rectangle":
				DrawShape shape1 = new DrawShape(canvas, ((JButton) e.getSource()).getText());
				canvas.addDrawListener(shape1);
				break;

			case "Fill Rectangle":
				DrawShape shape2 = new DrawShape(canvas, ((JButton) e.getSource()).getText());
				canvas.addDrawListener(shape2);
				break;

			case "Draw Oval":
				DrawShape shape3 = new DrawShape(canvas, ((JButton) e.getSource()).getText());
				canvas.addDrawListener(shape3);
				break;

			case "Fill Oval":
				DrawShape shape4 = new DrawShape(canvas, ((JButton) e.getSource()).getText());
				canvas.addDrawListener(shape4);
				break;

			case "Draw Line":
				DrawLine drawLine = new DrawLine(canvas);
				canvas.addDrawListener(drawLine);
				break;
			}

		}

	}

}
