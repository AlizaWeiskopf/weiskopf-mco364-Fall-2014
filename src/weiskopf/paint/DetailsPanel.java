package weiskopf.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailsPanel extends JPanel {

	private JButton chooseColor;
	private JButton clear;
	private JLabel strokeSize;
	private Canvas canvas;

	public DetailsPanel(Canvas canvas) {
		this.canvas = canvas;
		
		chooseColor = new JButton("Choose Color");
		chooseColor.setBackground(Color.GREEN);
		chooseColor.addActionListener(new ChooseColorListener(canvas));
		
		clear = new JButton("Clear");
		clear.addActionListener(new ClearScreenListener());
		
		strokeSize = new JLabel();
		setStrokeSize(canvas.getStroke());
		
		add(clear);
		add(chooseColor);
		add(strokeSize);
	}

	public void setStrokeSize(int size) {
		strokeSize.setText("Stroke size: " + size);
	}

	public JLabel getStrokeSize() {
		return strokeSize;
	}

	private class ChooseColorListener implements ActionListener {

		private Canvas canvas;

		public ChooseColorListener(Canvas canvas) {
			this.canvas = canvas;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Color color = JColorChooser.showDialog(canvas, "Choose Color", Color.GREEN);
			if (color != null) {
				canvas.setColor(color);
				chooseColor.setBackground(color);
			}
		}
	}
	

	private class ClearScreenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.clear();
		}
	}
}
