package weiskopf.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailsPanel extends JPanel {

	private JButton layers[] = new JButton[4];

	private JButton chooseColor;
	private JButton clear;

	private JLabel chooseLayer;
	private JLabel strokeSize;

	private Canvas canvas;

	public DetailsPanel(Canvas canvas) {
		this.canvas = canvas;

		ChooseLayerListener layerListener = new ChooseLayerListener(canvas);
		for (int i = 0; i < 4; i++) {
			layers[i] = new JButton(String.valueOf(i + 1));
			layers[i].addActionListener(layerListener);
		}
		layers[0].setBackground(Color.GRAY);

		chooseColor = new JButton("Choose Color");
		chooseColor.setBackground(Color.GREEN);
		chooseColor.addActionListener(new ChooseColorListener(canvas));

		clear = new JButton("Clear");
		clear.addActionListener(new ClearScreenListener());

		chooseLayer = new JLabel("Choose Layer:");

		strokeSize = new JLabel();
		setStrokeSize(canvas.getStrokeSize());

		add(chooseLayer);
		for (int i = 0; i < 4; i++) {
			add(layers[i]);
		}
		add(new JLabel("                               "));
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

	private class ChooseLayerListener implements ActionListener {

		private Canvas canvas;

		public ChooseLayerListener(Canvas canvas) {
			this.canvas = canvas;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 4; i++) {
				if (Color.GRAY.equals(layers[i].getBackground())) {
					layers[i].setBackground(null);
				}
			}
			JButton buttonClicked = (JButton) e.getSource();
			buttonClicked.setBackground(Color.GRAY);
			int layer = Integer.valueOf(buttonClicked.getText());
			canvas.setLayerSelected(layer - 1);

		}

	}
}
