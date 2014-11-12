package weiskopf.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ChooseColorPanel extends JPanel {

	private JButton chooseColor;
	private Canvas canvas;

	public ChooseColorPanel(Canvas canvas) {
		this.canvas = canvas;
		chooseColor = new JButton("Choose Color");
		chooseColor.addActionListener(new ChooseColorListener(canvas));
		add(chooseColor, BorderLayout.SOUTH);
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
			}
		}
	}
}
